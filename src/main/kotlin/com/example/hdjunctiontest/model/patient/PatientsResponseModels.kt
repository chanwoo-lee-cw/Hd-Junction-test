package com.example.hdjunctiontest.model.patient

import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "환자 타입")
data class PatientsTypeResponse (
    @Schema(description = "환자 검색 타입")
    val searchType: List<TypeModel<PatientSearchType>>,
    @Schema(description = "성별 타입")
    val genderType: List<TypeModel<GenderType>>
)

@Schema
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
    val phoneNumber: String?
)