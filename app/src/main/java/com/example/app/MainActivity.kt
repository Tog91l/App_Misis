package com.example.app

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ActivityMainBinding
import com.example.app.R
import com.example.app.CreateTaskActivity
import android.content.Intent
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        findViewById<ImageButton>(R.id.button).setOnClickListener {
            val intent = Intent(this, CreateTaskActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        adapter = TodoAdapter(TodoItemsRepository.getItems()) { position ->
        }
        findViewById<RecyclerView>(R.id.todo_recycler).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.adapter
        }
    }
}

