package com.example.hdjunctiontest.common.exception

import org.springframework.http.HttpStatus
import java.net.URI


const val URI_BLANK = "about:blank"

enum class ExceptionCode(
    val title: String,
    val httpStatus: HttpStatus,
    val detail: String? = null,
    val type: URI? = URI(URI_BLANK),
) {
    // 400 에러
    BAD_REQUEST("BAD REQUEST", HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    NOT_FIND_ENTITY_BY_ID("NOT_FIND_ENTITY_BY_ID", HttpStatus.NOT_FOUND, "DB의 해당하는 데이터가 존재하지 않습니다.", URI("https://docs.test-api/errors/not-find-entity-by-id")),

    // 500 Error
    SERVER_ERROR("SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR),

}
