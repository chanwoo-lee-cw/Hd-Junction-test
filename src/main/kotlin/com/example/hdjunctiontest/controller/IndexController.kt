package com.example.hdjunctiontest.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1")
class IndexController {

    @GetMapping
    fun index(): String {
        return "hello world!"
    }
}