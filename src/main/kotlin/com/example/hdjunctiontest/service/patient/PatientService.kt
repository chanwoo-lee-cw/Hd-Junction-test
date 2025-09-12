package com.example.hdjunctiontest.service.patient

import com.example.hdjunctiontest.common.exception.EntityNotFoundException
import com.example.hdjunctiontest.common.exception.ExceptionCode
import com.example.hdjunctiontest.domain.entity.patient.Patients
import com.example.hdjunctiontest.dto.patient.PatientSaveDto
import com.example.hdjunctiontest.dto.patient.PatientUpdateDto
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

    @Transactional
    fun updatePatient(patientUpdateDto: PatientUpdateDto) {
        val patient = patientRepository.findById(patientUpdateDto.id)
        if (patient == null) {
            throw EntityNotFoundException(ExceptionCode.NOT_FIND_ENTITY_BY_ID)
        }
        patient.update(patientUpdateDto)
        patientRepository.save(patient)
    }
}