package com.example.hdjunctiontest.application.patient

import com.example.hdjunctiontest.dto.patient.PatientSaveDto
import com.example.hdjunctiontest.dto.patient.PatientUpdateDto
import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.model.patient.PatientUpdateRequest
import com.example.hdjunctiontest.model.patient.PatientsResponse
import com.example.hdjunctiontest.model.patient.PatientsTypeResponse
import com.example.hdjunctiontest.service.patient.PatientService
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType
import org.springframework.stereotype.Service

@Service
class PatientApplication(
    private val patientService: PatientService,
) {

    fun types(): PatientsTypeResponse {
        return PatientsTypeResponse(
            searchType = PatientSearchType.typeEntries.map { TypeModel(it, it.value) },
            genderType = GenderType.typeEntries.map { TypeModel(it, it.value) }
        )
    }

    fun findDetailById(id: Long): PatientsResponse {
        val patientDetailDto = patientService.findPatientById(id)

        with(patientDetailDto) {
            return PatientsResponse(
                name = name,
                hospitalName = hospitalName,
                patientCode = patientCode,
                genderCode = genderCode.value,
                birthDay = birthDay,
                phoneNumber = phoneNumber,
                visits = visits.map {
                    PatientsResponse.VisitsListResponse(
                        it.visitedDate,
                        it.receiptStatusCode
                    )
                }
            )
        }
    }


    fun registerPatient(
        registerRequest: PatientRegisterRequest
    ) {
        patientService.registerPatient(
            PatientSaveDto.of(registerRequest)
        )
    }


    fun updatePatient(
        id: Long,
        updateRequest: PatientUpdateRequest
    ) {
        patientService.updatePatient(
            id,
            PatientUpdateDto.of(updateRequest)
        )
    }


    fun deletePatient(
        id: Long,
    ) {
        patientService.deletePatient(id)
    }
}