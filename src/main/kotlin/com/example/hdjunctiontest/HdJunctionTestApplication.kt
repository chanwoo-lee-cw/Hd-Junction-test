package com.example.hdjunctiontest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@EnableCaching
@SpringBootApplication
class HdJunctionTestApplication

fun main(args: Array<String>) {
    runApplication<HdJunctionTestApplication>(*args)
}
