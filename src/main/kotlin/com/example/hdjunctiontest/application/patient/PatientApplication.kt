package com.example.hdjunctiontest.application.patient

import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.model.patient.PatientsSearchTypeResponse
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType
import org.springframework.stereotype.Service

@Service
class PatientApplication {

    fun types(): PatientsSearchTypeResponse {
        return PatientsSearchTypeResponse(
            searchType = PatientSearchType.typeEntries.map { TypeModel(it, it.value) },
            genderType = GenderType.typeEntries.map { TypeModel(it, it.value) }
        )
    }
}