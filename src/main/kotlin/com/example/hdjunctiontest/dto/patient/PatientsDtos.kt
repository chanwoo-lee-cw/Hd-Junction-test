package com.example.hdjunctiontest.dto.patient

import com.example.hdjunctiontest.domain.entity.patient.Patients
import com.example.hdjunctiontest.dto.visited.VisitsListDto
import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.model.patient.PatientUpdateRequest
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.util.RandomUtil

data class PatientsDetailDto(
    val name: String,
    val hospitalName: String,
    val patientCode: String,
    val genderCode: GenderType,
    val birthDay: String?,
    val phoneNumber: String?,
    val visits: List<VisitsListDto>
) {
    companion object {
        fun of(patients: Patients): PatientsDetailDto {
            with(patients) {
                return PatientsDetailDto(
                    name = name,
                    hospitalName = hospital?.name ?: "",
                    patientCode = patientCode,
                    genderCode = genderCode,
                    birthDay = birthDay,
                    phoneNumber = phoneNumber,
                    visits = visits.map { VisitsListDto.of(it) }
                )
            }
        }
    }
}


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
    val name: String,
    val genderCode: GenderType,
    val birthDay: String?,
    val phoneNumber: String?,
) {
    companion object {
        fun of(request: PatientUpdateRequest): PatientUpdateDto {
            with(request) {
                return PatientUpdateDto(
                    name = name,
                    genderCode = genderCode,
                    birthDay = birthDay,
                    phoneNumber = phoneNumber,
                )
            }
        }
    }
}