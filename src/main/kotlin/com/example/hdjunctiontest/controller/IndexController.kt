package com.example.hdjunctiontest.controller

import io.swagger.v3.oas.annotations.Hidden
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class IndexController {

    @GetMapping
    @Hidden
    fun index(): String {
        return "hello world!"
    }

    @GetMapping("throw-error")
    fun throwError(): Unit {
        throw Exception()
    }
}