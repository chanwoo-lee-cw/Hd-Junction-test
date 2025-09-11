package com.example.hdjunctiontest.controller.patient

import com.example.hdjunctiontest.application.patient.PatientApplication
import com.example.hdjunctiontest.common.responose.ApiResponse
import com.example.hdjunctiontest.model.patient.PatientsSearchTypeResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/patient")
class PatientController(
    val patientApplication: PatientApplication,
) {

    @GetMapping("/types")
    fun type(): ApiResponse<PatientsSearchTypeResponse> {
        return ApiResponse.success(
            patientApplication.types()
        )
    }
}