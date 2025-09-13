package com.example.hdjunctiontest.model.patient

import com.example.hdjunctiontest.dto.patient.PatientsListDto
import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType
import io.swagger.v3.oas.annotations.media.Schema
import java.time.Instant

@Schema(description = "환자 타입")
data class PatientsTypeResponse (
    @Schema(description = "환자 검색 타입")
    val searchType: List<TypeModel<PatientSearchType>>,
    @Schema(description = "성별 타입")
    val genderType: List<TypeModel<String>>
)


@Schema(description = "환자 목록 조회")
data class PatientsListResponse(
    val name: String,
    val patientCode: String,
    val genderCode: GenderType,
    val birthDay: String?,
    val phoneNumber: String?,
) {
    companion object {
        fun of(dto: PatientsListDto): PatientsListResponse {
            return PatientsListResponse(
                name = dto.name,
                patientCode = dto.patientCode,
                genderCode = dto.genderCode,
                birthDay = dto.birthDay,
                phoneNumber = dto.phoneNumber,
            )
        }
    }
}

@Schema(description = "환자 상세 조회")
data class PatientsResponse (
    @Schema(description = "환자 이름")
    val name: String,
    @Schema(description = "병원 이름")
    val hospitalName: String,
    @Schema(description = "환자 등록 번호")
    val patientCode: String,
    @Schema(description = "환자 성별")
    val genderCode: String,
    @Schema(description = "생년 월일")
    val birthDay: String?,
    @Schema(description = "전화 번호")
    val phoneNumber: String?,
    @Schema(description = "방문 리스트")
    val visits: List<VisitsListResponse>
) {
    @Schema(description = "방문 리스트")
    data class VisitsListResponse (
        @Schema(description = "방문 날짜")
        val visitedDate: Instant,
        @Schema(description = "방문 상태 코드")
        val receiptStatusCode: String,
        @Schema(description = "방문 상태")
        val receiptStatus: String,
        @Schema(description = "진료 과목 코드")
        val medicalSubjectCode: String,
        @Schema(description = "진료 과목")
        val medicalSubject: String,
        @Schema(description = "진료 유형 코드")
        val medicalTypeCode: String,
        @Schema(description = "진료 유형")
        val medicalType: String,
    )
}