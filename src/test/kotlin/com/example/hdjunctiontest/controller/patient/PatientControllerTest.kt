package com.example.hdjunctiontest.controller.patient


import com.example.hdjunctiontest.controller.util.TestUtils
import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.model.patient.PatientUpdateRequest
import com.example.hdjunctiontest.type.GenderType
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*
import org.springframework.restdocs.operation.preprocess.Preprocessors.*
import org.springframework.restdocs.payload.PayloadDocumentation.*
import org.springframework.restdocs.request.RequestDocumentation.*
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "build/generated-snippets")
@ActiveProfiles("test")
@Transactional
class PatientControllerTest(
    @Autowired val mockMvc: MockMvc,
    @Autowired val objectMapper: ObjectMapper,
) {
    @Test
    @Disabled("환자 타입 조회")
    fun type() {
        // given
        // when

        // then
        mockMvc.perform(
            get("/api/v1/patient/types")
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient-types",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        subsectionWithPath("data.searchType").description("검색 타입 목록(label : 고객 표기용, value : 보내줘야할 값)"),
                        fieldWithPath("data.searchType[].value").description("검색 타입 코드"),
                        fieldWithPath("data.searchType[].label").description("검색 타입"),
                        subsectionWithPath("data.genderType").description("성별 목록"),
                        fieldWithPath("data.genderType[].value").description("성별 코드"),
                        fieldWithPath("data.genderType[].label").description("성별")
                    )
                )
            )
    }

    @Test
    @Disabled("환자 목록 조회")
    fun findAllByPage() {
        // given
//        val searchType = "NAME"
//        val searchValue = "He"
        // when
        val answer = mockMvc.perform(
            get("/api/v1/patient")
//                .param("searchType", searchType)
//                .param("searchValue", searchValue)
                .accept(MediaType.APPLICATION_JSON)
        )
        // then
        answer.andExpect(status().isOk)
            .andDo(
                document(
                    "patient-list",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    queryParameters(
                        parameterWithName("searchType").optional().description("검색 조건, `환자 타입 조회` 참고"),
                        parameterWithName("searchValue").optional().description("검색 값"),
                        parameterWithName("pageNo").optional().description("페이지 번호"),
                        parameterWithName("pageSize").optional().description("페이지 사이즈"),
                    ),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        subsectionWithPath("data.content").description("환자 목록 정보"),
                        fieldWithPath("data.content[].name").description("환자 이름"),
                        fieldWithPath("data.content[].patientCode").description("환자 등록 번호"),
                        fieldWithPath("data.content[].genderCode").description("환자 성별"),
                        fieldWithPath("data.content[].birthDay").optional().description("생년 월일"),
                        fieldWithPath("data.content[].phoneNumber").optional().description("전화 번호"),
                        *TestUtils.getPageFieldsList()
                    )
                )
            )
    }

    @Test
    @Disabled("환자 등록")
    fun insert() {
        // given
        val request = PatientRegisterRequest(
            hospitalId = 1L,
            name = "Hello",
            genderCode = GenderType.M,
            birthDay = "2000-01-01",
            phoneNumber = "010-2222-3333"
        )
        // when & then
        mockMvc.perform(
            post("/api/v1/patient")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient-insert",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    requestFields(
                        fieldWithPath("hospitalId").description("병원 ID"),
                        fieldWithPath("name").description("환자명"),
                        fieldWithPath("genderCode").description("성별 코드)"),
                        fieldWithPath("birthDay").optional().description("생년월일"),
                        fieldWithPath("phoneNumber").optional().description("전화번호")
                    ),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        fieldWithPath("data").optional().description("항상 null")
                    )
                )
            )
    }

    @Test
    @Disabled("환자 상세 조회")
    fun findOne() {
        // given
        val id = 1L

        // when
        // then
        mockMvc.perform(
            get("/api/v1/patient/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient-update",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    pathParameters(
                        parameterWithName("id").description("환자 ID")
                    ),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        fieldWithPath("data.name").description("환자명"),
                        fieldWithPath("data.hospitalName").description("병원명"),
                        fieldWithPath("data.patientCode").description("환자 코드"),
                        fieldWithPath("data.genderCode").description("성별"),
                        fieldWithPath("data.birthDay").optional().description("생년월일"),
                        fieldWithPath("data.phoneNumber").optional().description("전화번호"),

                        subsectionWithPath("data.visits").description("방문 긹"),
                        fieldWithPath("data.visits[].visitedDate").description("방문 날짜"),
                        fieldWithPath("data.visits[].receiptStatusCode").description("방문 상태 코드"),
                        fieldWithPath("data.visits[].receiptStatus").description("방문 상태"),
                        fieldWithPath("data.visits[].medicalSubjectCode").description("진료 과목 코드"),
                        fieldWithPath("data.visits[].medicalSubject").description("진료 과목"),
                        fieldWithPath("data.visits[].medicalTypeCode").description("진료 유형 코드"),
                        fieldWithPath("data.visits[].medicalType").description("진료 유형")
                    )
                )
            )
    }

    @Test
    @Disabled("환자 수정")
    fun update() {
        // given
        val id = 1L;
        val request = PatientUpdateRequest(
            name = "Hello",
            genderCode = GenderType.M,
            birthDay = "2000-01-01",
            phoneNumber = "010-2222-3333"
        )
        // when

        // then
        mockMvc.perform(
            put("/api/v1/patient/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request))
                .accept(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient-update",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    pathParameters(
                        parameterWithName("id").description("환자 ID")
                    ),
                    requestFields(
                        fieldWithPath("name").description("환자명"),
                        fieldWithPath("genderCode").description("성별 코드)"),
                        fieldWithPath("birthDay").optional().description("생년월일"),
                        fieldWithPath("phoneNumber").optional().description("전화번호")
                    ),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        fieldWithPath("data").optional().description("항상 null")
                    )
                )
            )

    }

    @Test
    @Disabled("환자 삭제")
    fun delete() {
        // given
        val id = 1L;
        // when

        // then
        mockMvc.perform(
            delete("/api/v1/patient/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient-delete",
                    preprocessRequest(prettyPrint()),
                    preprocessResponse(prettyPrint()),
                    pathParameters(
                        parameterWithName("id").description("환자 ID")
                    ),
                    responseFields(
                        fieldWithPath("status").description("http 코드"),
                        fieldWithPath("data").optional().description("항상 null")
                    )
                )
            )
    }

}