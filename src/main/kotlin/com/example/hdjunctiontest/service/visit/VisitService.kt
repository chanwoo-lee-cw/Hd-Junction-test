package com.example.hdjunctiontest.service.visit

import com.example.hdjunctiontest.repository.visit.VisitRepository
import org.springframework.stereotype.Service

@Service
class VisitService(
    private val visitRepository: VisitRepository,
) {

}