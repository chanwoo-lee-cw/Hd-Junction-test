package com.example.hdjunctiontest.model.visit

import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.type.PatientSearchType
import io.swagger.v3.oas.annotations.media.Schema

class VisitTypeResponse (
    @Schema(description = "방문상태코드")
    val receiptStatusType: List<TypeModel<String>>,
    @Schema(description = "진료과목코드")
    val medicalSubjectType: List<TypeModel<String>>,
    @Schema(description = "진료유형코드")
    val medicalType: List<TypeModel<String>>
)