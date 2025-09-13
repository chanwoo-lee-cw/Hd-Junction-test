package com.example.hdjunctiontest.repository.visit

import com.example.hdjunctiontest.domain.entity.visit.Visits
import org.springframework.data.jpa.repository.JpaRepository

interface VisitRepository: JpaRepository<Visits, Long> {
}