package com.example.hdjunctiontest.dto.patient

import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.util.RandomUtil
import java.math.BigInteger

data class PatientSaveDto(
    val hospitalId: BigInteger,
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