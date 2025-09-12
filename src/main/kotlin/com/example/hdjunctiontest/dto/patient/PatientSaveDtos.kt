package com.example.hdjunctiontest.dto.patient

import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.model.patient.PatientUpdateRequest
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.util.RandomUtil

data class PatientSaveDto(
    val hospitalId: Long,
    val name: String,
    val genderCode: GenderType,
    val patientCode: String,
    val birthDay: String?,
    val phoneNumber: String?,
) {
    companion object {
        fun of(request: PatientRegisterRequest): PatientSaveDto {
            with(request) {
                return PatientSaveDto(
                    hospitalId = hospitalId,
                    name = name,
                    genderCode = genderCode,
                    patientCode = RandomUtil.getRandomString(10),
                    birthDay = birthDay,
                    phoneNumber = phoneNumber,
                )
            }
        }
    }
}


data class PatientUpdateDto(
    val id: Long,
    val name: String,
    val genderCode: GenderType,
    val birthDay: String?,
    val phoneNumber: String?,
) {
    companion object {
        fun of(request: PatientUpdateRequest): PatientUpdateDto {
            with(request) {
                return PatientUpdateDto(
                    id = id,
                    name = name,
                    genderCode = genderCode,
                    birthDay = birthDay,
                    phoneNumber = phoneNumber,
                )
            }
        }
    }
}