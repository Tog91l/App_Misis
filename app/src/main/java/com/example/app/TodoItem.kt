package com.example.app

data class TodoItem(
    val oid: String,
    val text: String,
    val priority: String,
    val deadline: String? = null,
    var isDone: Boolean,
    val changedDate: String? = null,
    val createdDate: Long = System.currentTimeMillis()
)

