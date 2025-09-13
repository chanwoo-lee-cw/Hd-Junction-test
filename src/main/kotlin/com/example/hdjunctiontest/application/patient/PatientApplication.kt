package com.example.hdjunctiontest.application.patient

import com.example.hdjunctiontest.dto.patient.PatientFilterDto
import com.example.hdjunctiontest.dto.patient.PatientSaveDto
import com.example.hdjunctiontest.dto.patient.PatientUpdateDto
import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.model.patient.*
import com.example.hdjunctiontest.service.code.CodeService
import com.example.hdjunctiontest.service.patient.PatientService
import com.example.hdjunctiontest.type.CodeGroupType
import com.example.hdjunctiontest.type.PatientSearchType
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class PatientApplication(
    private val patientService: PatientService,
    private val codeService: CodeService,
) {

    fun types(): PatientsTypeResponse {
        return PatientsTypeResponse(
            searchType = PatientSearchType.typeEntries.map { TypeModel(it, it.value) },
            genderType = codeService.findAllByCodeGroup(CodeGroupType.GENDER).map { TypeModel(it.code, it.codeName) },
        )
    }

    fun findAllByPage(
        searchRequest: PatientFilterRequest,
        pageable: Pageable
    ): Page<PatientsListResponse> {
        return patientService.findAllByPage(
            PatientFilterDto.of(searchRequest),
            pageable
        ).map { PatientsListResponse.of(it) }
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