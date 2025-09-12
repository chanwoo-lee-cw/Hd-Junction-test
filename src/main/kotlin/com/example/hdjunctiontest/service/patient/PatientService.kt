package com.example.hdjunctiontest.service.patient

import com.example.hdjunctiontest.domain.entity.patient.Patients
import com.example.hdjunctiontest.dto.patient.PatientSaveDto
import com.example.hdjunctiontest.repository.patient.PatientRepository

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class PatientService(
    private val patientRepository: PatientRepository
) {

    @Transactional
    fun registerPatient(patientSaveDto: PatientSaveDto) {
        patientRepository.save(
            Patients.of(patientSaveDto)
        )
    }
}