package com.example.hdjunctiontest.controller.visit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest
import org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse
import org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.payload.PayloadDocumentation.subsectionWithPath
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@ActiveProfiles("test")
@Transactional
class VisitControllerTest(
    @Autowired val mockMvc: MockMvc,
) {
    @Test
    @Disabled("방문 타입 조회")
    fun getTypes() {
        // given

        // when
        val answer = mockMvc.perform(
            get("/api/v1/visit/types")
                .accept(MediaType.APPLICATION_JSON)
        )
        // then
        answer.andExpect(status().isOk)
            .andDo(
                document(
                    "visit-types",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        subsectionWithPath("data.receiptStatusType").description("방문상태코드"),
                        fieldWithPath("data.receiptStatusType[].value").description("값"),
                        fieldWithPath("data.receiptStatusType[].label").description("라벨"),
                        subsectionWithPath("data.medicalSubjectType").description("진료과목코드"),
                        fieldWithPath("data.medicalSubjectType[].value").description("값"),
                        fieldWithPath("data.medicalSubjectType[].label").description("라벨"),
                        subsectionWithPath("data.medicalType").description("진료유형코드"),
                        fieldWithPath("data.medicalType[].value").description("값"),
                        fieldWithPath("data.medicalType[].label").description("라벨")
                    )
                )
            )

    }

}