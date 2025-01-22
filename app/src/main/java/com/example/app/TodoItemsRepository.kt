package com.example.app

object TodoItemsRepository {

    private val items = mutableListOf<TodoItem>()

    init {
        items.add(TodoItem("1", "Buy groceries", "ordinary", isDone = false,))
        items.add(TodoItem("2", "Complete homework", "urgent", isDone = false))
        items.add(TodoItem("3", "Call mom", "low", isDone = false))

    }
    fun getItems(): List<TodoItem> = items

    fun addItem(item: TodoItem) {
        items.add(item)
    }

    fun removeItem(index: Int) {
        if (index in items.indices) items.removeAt(index)
    }

    fun updateItem(index: Int, newItem: TodoItem) {
        if (index in items.indices) items[index] = newItem
    }

}
