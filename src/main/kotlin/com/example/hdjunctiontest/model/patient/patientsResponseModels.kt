package com.example.hdjunctiontest.model.patient

import com.example.hdjunctiontest.model.TypeModel

data class PatientsSearchTypeResponse (
    val searchType: List<TypeModel<String>>
)
