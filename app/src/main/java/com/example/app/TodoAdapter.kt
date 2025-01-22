package com.example.app
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.TodoItem

class TodoAdapter(
    private val items: List<TodoItem>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textView: TextView = view.findViewById(R.id.duty_text)
        private val checkBox: CheckBox = view.findViewById(R.id.checkbox)

        fun bind(item: TodoItem, position: Int) {
            textView.text = item.text
            checkBox.isChecked = item.isDone
            itemView.setOnClickListener { onItemClicked(position) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.frame_duty, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(items[position], position)
    }

    override fun getItemCount(): Int = items.size
}
