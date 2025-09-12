package com.example.hdjunctiontest.common.responose

import org.springframework.http.HttpStatus

data class ApiResponse<T>(
    val status: Int,
    val data: T? = null,
) {
    companion object {
        fun success() = ApiResponse<Unit>(
            HttpStatus.OK.value(),
        )

        fun <T> success(data: T?) = ApiResponse<T>(
            HttpStatus.OK.value(),
            data = data
        )
    }
}