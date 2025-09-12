package com.example.hdjunctiontest.application.patient

import com.example.hdjunctiontest.dto.patient.PatientSaveDto
import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
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

    fun registerPatient(
        registerRequest: PatientRegisterRequest
    ) {
        patientService.registerPatient(
            PatientSaveDto.of(registerRequest)
        )
    }
}