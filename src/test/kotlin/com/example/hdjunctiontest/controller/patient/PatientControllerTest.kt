package com.example.hdjunctiontest.controller.patient


import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.model.patient.PatientUpdateRequest
import com.example.hdjunctiontest.model.patient.PatientsResponse
import com.example.hdjunctiontest.model.patient.PatientsTypeResponse
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType
import com.fasterxml.jackson.databind.ObjectMapper
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
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.transaction.annotation.Transactional
import java.time.Instant


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

//    @Test
//    fun findAllByPage() {
//
//        //given
//        //w
//    }

    @Test
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