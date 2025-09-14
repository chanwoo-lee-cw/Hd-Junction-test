package com.example.hdjunctiontest.controller.util

import org.springframework.restdocs.payload.FieldDescriptor
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath

object TestUtils {
    fun getPageFieldsList(): Array<FieldDescriptor> = arrayOf(
        subsectionWithPath("data.pageable").description("페이지 요청 정보"),
        fieldWithPath("data.totalElements").description("총 요소 수"),
        fieldWithPath("data.totalPages").description("총 페이지 수"),
        fieldWithPath("data.last").description("마지막 페이지 여부"),
        fieldWithPath("data.numberOfElements").description("현재 페이지 요소 수"),
        fieldWithPath("data.number").description("현재 페이지 번호"),
        fieldWithPath("data.first").description("첫 페이지 여부"),
        subsectionWithPath("data.sort").description("정렬 정보"),
        fieldWithPath("data.size").description("페이지 크기"),
        fieldWithPath("data.empty").description("비었는지 여부")
    )
}