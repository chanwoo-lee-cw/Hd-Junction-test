package com.example.hdjunctiontest.controller

import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.restdocs.RestDocumentationExtension
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import kotlin.test.Test


@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@WebMvcTest(IndexController::class)
@ExtendWith(RestDocumentationExtension::class)
@ActiveProfiles("test")
class IndexControllerTest(
    @Autowired val mockMvc: MockMvc,
) {
    @Test
    fun throwError() {
        mockMvc.perform(
            get("/api/v1/throw-error")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isInternalServerError)
            .andDo(
                document(
                    "error-format",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    responseFields(
                        fieldWithPath("type").description("문제 정보 참고용 URI"),
                        fieldWithPath("title").description("문제 요약 제목"),
                        fieldWithPath("status").description("http 코드"),
                        fieldWithPath("instance").description("에러가 발생한 URI"),
                        fieldWithPath("detail").description("에러 상세 설명").optional(),
                    )
                )
            )
    }
}