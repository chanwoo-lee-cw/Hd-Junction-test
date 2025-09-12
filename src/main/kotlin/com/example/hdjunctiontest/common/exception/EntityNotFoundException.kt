package com.example.hdjunctiontest.common.exception

data class EntityNotFoundException(
    val responseCode: ExceptionCode,
    override val cause: Throwable? = null,
    val customMessage: String? = responseCode.detail,
    val data: Any? = null
) : RuntimeException(customMessage ?: responseCode.detail, cause)