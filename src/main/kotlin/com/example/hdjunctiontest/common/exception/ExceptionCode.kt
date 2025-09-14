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
    NOT_FIND_ENTITY("NOT_FIND_ENTITY", HttpStatus.NOT_FOUND, "DB의 해당하는 데이터가 존재하지 않습니다."),
    NOT_FIND_ENTITY_BY_ID("NOT_FIND_ENTITY_BY_ID", HttpStatus.NOT_FOUND, "DB의 해당하는 데이터가 존재하지 않습니다."),
    INVALID_REQUEST_NOT_SEARCH_TYPE("INVALID_REQUEST_NOT_SEARCH_TYPE", HttpStatus.BAD_REQUEST, "검색 필터의 타입이 없습니다."),

    // 500 Error
    SERVER_ERROR("SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "요청을 처리 중 문제가 발생했습니다."),

}
