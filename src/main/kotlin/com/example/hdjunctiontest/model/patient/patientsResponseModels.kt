package com.example.hdjunctiontest.model.patient

import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.type.GenderType
import com.example.hdjunctiontest.type.PatientSearchType

data class PatientsSearchTypeResponse (
    val searchType: List<TypeModel<PatientSearchType>>,
    val genderType: List<TypeModel<GenderType>>
)
