package com.example.hdjunctiontest.common.responose

import org.springframework.http.HttpStatus

data class ApiResponse<T>(
    val status: HttpStatus,
    val data: T? = null,
) {
    companion object {
        fun success() = ApiResponse<Unit>(
            HttpStatus.OK,
        )

        fun <T> success(data: T?) = ApiResponse<T>(
            HttpStatus.OK,
            data = data
        )
    }
}