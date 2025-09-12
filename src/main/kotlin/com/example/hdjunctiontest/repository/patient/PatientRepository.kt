package com.example.hdjunctiontest.repository.patient

import com.example.hdjunctiontest.domain.entity.patient.Patients
import org.springframework.data.jpa.repository.JpaRepository
import java.math.BigInteger

interface PatientRepository : JpaRepository<Patients, BigInteger> {
    fun save(patient: Patients)
}