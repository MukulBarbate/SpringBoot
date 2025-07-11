package com.example.helloworld.controller

import com.example.helloworld.model.Todo
import com.example.helloworld.model.TodoRequest
import com.example.helloworld.repository.TodoRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController(
    private val todoRepository: TodoRepository
) {

    @GetMapping
    fun getTodos(): List<Todo> = todoRepository.findAll()

    @PostMapping
    fun addTodo(@RequestBody request: TodoRequest): Todo {
        val todo = Todo(title = request.title, isCompleted = request.isCompleted)
        return todoRepository.save(todo)
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: String): Todo? =
        todoRepository.findById(id).orElse(null)

    @PutMapping("/{id}")
    fun markCompleted(@PathVariable id: String): Todo? {
        val todo = todoRepository.findById(id).orElse(null)
        return if (todo != null) {
            val updated = todo.copy(isCompleted = true)
            todoRepository.save(updated)
        } else null
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: String): Boolean {
        return if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id)
            true
        } else false
    }
}





























/*
package com.example.helloworld.controller

import com.example.helloworld.model.Todo
import com.example.helloworld.model.TodoRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/todos")
class TodoController {

    private val todos = mutableListOf<Todo>()
    private var nextId = 1

    @GetMapping
    fun getTodos(): List<Todo> = todos.sortedBy { it.id }

    @PostMapping
    fun addTodo(@RequestBody todo: TodoRequest): Todo {
        val mTodo = Todo(
            title = todo.title,
            isCompleted = todo.isCompleted
        )
        todos.add(mTodo)
        return mTodo
    }

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable id: String): Todo? {
        val todo = todos.find { it.id.equals(id) }
        todo?.isCompleted = true
        return todo
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable id: String): Boolean {
        return todos.removeIf { it.id.equals(id) }
    }
    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: String): Todo? {
        val todo = todos.find { it.id == id }
        return todo
    }

    @GetMapping(params = ["id"])
    fun getTodoByQueryParam(@RequestParam id: String): Todo? {
        return todos.find { it.id == id }
    }
}
*/

