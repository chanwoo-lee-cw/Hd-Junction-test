package com.example.hdjunctiontest.util

object RandomUtil {
    private val charset = ('0'..'9') + ('a'..'z') + ('A'..'Z')

    fun getRandomString(length: Int): String = List(10) { charset.random() }.joinToString("")
}