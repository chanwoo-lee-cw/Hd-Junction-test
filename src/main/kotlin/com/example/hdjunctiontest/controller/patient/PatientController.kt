package com.example.hdjunctiontest.controller.patient

import com.example.hdjunctiontest.application.patient.PatientApplication
import com.example.hdjunctiontest.common.responose.ApiResponse
import com.example.hdjunctiontest.model.patient.PatientRegisterRequest
import com.example.hdjunctiontest.model.patient.PatientUpdateRequest
import com.example.hdjunctiontest.model.patient.PatientsResponse
import com.example.hdjunctiontest.model.patient.PatientsTypeResponse
import io.swagger.v3.oas.annotations.Operation
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/v1/patient")
class PatientController(
    val patientApplication: PatientApplication,
) {

    @Operation(summary = "환자 타입 조회")
    @GetMapping("/types")
    fun type(): ApiResponse<PatientsTypeResponse> {
        return ApiResponse.success(
            patientApplication.types()
        )
    }

    @Operation(summary = "환자 등록")
    @PostMapping
    fun insert(
        @RequestBody @Valid registerRequest: PatientRegisterRequest
    ): ApiResponse<Unit> {
        patientApplication.registerPatient(registerRequest)
        return ApiResponse.success()
    }


    @Operation(summary = "환자 조회")
    @GetMapping("{id}")
    fun findOne(
        @PathVariable id: Long,
    ): ApiResponse<PatientsResponse> {
        return ApiResponse.success(
            patientApplication.findDetailById(id)
        )
    }

    @Operation(summary = "환자 수정")
    @PutMapping("{id}")
    fun update(
        @PathVariable id: Long,
        @RequestBody @Valid updateRequest: PatientUpdateRequest
    ): ApiResponse<Unit> {
        patientApplication.updatePatient(id, updateRequest)
        return ApiResponse.success()
    }

    @Operation(summary = "환자 삭제")
    @DeleteMapping("{id}")
    fun delete(
        @PathVariable id: Long,
    ): ApiResponse<Unit> {
        patientApplication.deletePatient(id)
        return ApiResponse.success()
    }
}