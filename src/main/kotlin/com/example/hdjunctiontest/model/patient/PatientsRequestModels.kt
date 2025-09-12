package com.example.hdjunctiontest.model.patient

import com.example.hdjunctiontest.type.GenderType
import io.swagger.v3.oas.annotations.media.Schema
import java.math.BigInteger

@Schema(description = "환자 등록")
data class PatientRegisterRequest (
    @Schema(description = "병원 ID")
    val hospitalId: BigInteger,
    @Schema(description = "환자명")
    val name: String,
    @Schema(description = "성별 코드")
    val genderCode: GenderType,
    @Schema(description = "생년월일")
    val birthDay: String?,
    @Schema(description = "전화번호")
    val phoneNumber: String?,
)
