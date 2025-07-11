package com.example.helloworld.model



import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document(collection = "todos")
data class Todo(
    @Id
    val id: String? = null,
    val title: String,
    var isCompleted: Boolean = false,
    val createdAt: Instant = Instant.now()
)
data class TodoRequest(
    val title: String,
    var isCompleted: Boolean = false,
)