package com.example.hdjunctiontest.common.responose

import com.example.hdjunctiontest.common.exception.EntityNotFoundException
import com.example.hdjunctiontest.common.exception.ExceptionCode
import jakarta.servlet.http.HttpServletRequest
import mu.KotlinLogging
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.net.URI
import java.util.*

@RestControllerAdvice
class CommonExceptionHandler {
    private val log = KotlinLogging.logger {}

    fun ProblemDetail.withTitle(title: String) = apply { this.title = title }
    fun ProblemDetail.withType(type: URI?) = apply { type?.let { this.type = type } }

    @ExceptionHandler(EntityNotFoundException::class)
    fun entityNotFoundExceptionHandler(
        exception: EntityNotFoundException,
    ): ResponseEntity<ProblemDetail> {
        log.warn { exception }
        val problemDetail = ProblemDetail
            .forStatusAndDetail(exception.responseCode.httpStatus, exception.message)
            .withTitle(exception.responseCode.title)
            .withType(exception.responseCode.type)
        return ResponseEntity.of(
            problemDetail
        ).build()
    }

    @ExceptionHandler(Exception::class)
    fun exceptionHandler(
        exception: Exception,
        // 아래 2개는 선택값
        request: HttpServletRequest,
        locale: Locale?
    ): ResponseEntity<ProblemDetail> {
        log.warn { exception }
        val responseCode = ExceptionCode.SERVER_ERROR

        return ResponseEntity.of(
            ProblemDetail.forStatusAndDetail(responseCode.httpStatus, exception.message ?: responseCode.detail)
                .withTitle(responseCode.title)
        ).build()
    }


}