package com.example.hdjunctiontest.repository.patient

import com.example.hdjunctiontest.domain.entity.patient.Patients
import org.springframework.data.jpa.repository.JpaRepository

interface PatientRepository : JpaRepository<Patients, Long>, PatientRepositoryCustom {
    fun save(patient: Patients)
}