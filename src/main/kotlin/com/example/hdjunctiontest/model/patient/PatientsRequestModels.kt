package com.example.hdjunctiontest.model.patient

import com.example.hdjunctiontest.common.exception.ExceptionCode
import com.example.hdjunctiontest.common.exception.InvalidRequestValueException
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType
import io.swagger.v3.oas.annotations.media.Schema


@Schema(description = "환자 목록 조회")
data class PatientFilterRequest (
    @Schema(description = "검색 조건")
    val searchType: PatientSearchType? = null,
    @Schema(description = "검색 값")
    val searchValue: String? = null
) {
    init {
        if (searchValue != null && searchType == null) {
            throw InvalidRequestValueException(ExceptionCode.INVALID_REQUEST_NOT_SEARCH_TYPE)
        }
    }
}


@Schema(description = "환자 등록")
data class PatientRegisterRequest (
    @Schema(description = "병원 ID")
    val hospitalId: Long,
    @Schema(description = "환자명")
    val name: String,
    @Schema(description = "성별 코드")
    val genderCode: GenderType,
    @Schema(description = "생년월일")
    val birthDay: String?,
    @Schema(description = "전화번호")
    val phoneNumber: String?,
)


@Schema(description = "환자 수정")
data class PatientUpdateRequest (
    @Schema(description = "환자명")
    val name: String,
    @Schema(description = "성별 코드")
    val genderCode: GenderType,
    @Schema(description = "생년월일")
    val birthDay: String?,
    @Schema(description = "전화번호")
    val phoneNumber: String?,
)
