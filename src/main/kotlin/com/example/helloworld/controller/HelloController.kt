package com.example.helloworld.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class HelloController {
    @GetMapping("/hello")
    fun sayHello(): String {
        return "Hello, Spring Boot!"
    }

    @GetMapping("/name")
    fun sayName(): String {
        return "Hello, Mukul!"
    }

    @GetMapping("/bye")
    fun sayBye(): String {
        return "Bye, Spring Boot!"
    }
}