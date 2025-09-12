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
