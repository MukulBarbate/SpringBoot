package com.example.helloworld.repository

import com.example.helloworld.model.Todo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : MongoRepository<Todo, String>
