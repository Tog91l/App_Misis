package com.example.app

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.app.R
import java.util.UUID
import java.util.Calendar
import com.example.app.TodoItemsRepository

class CreateTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_duty_frame)

        val editTask = findViewById<EditText>(R.id.edit_task)
        val spinner = findViewById<Spinner>(R.id.importance_spinner)
        val saveButton = findViewById<TextView>(R.id.save_button)
        val closeButton = findViewById<ImageView>(R.id.close_button)
        val priorities = resources.getStringArray(R.array.priority_levels)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, priorities)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        saveButton.setOnClickListener {
            val newTask = TodoItem(
                oid = UUID.randomUUID().toString(),
                text = editTask.text.toString(),
                priority = spinner.selectedItem.toString(),
                isDone = false
            )
            TodoItemsRepository.addItem(newTask)
            finish()
        }

    }
}


