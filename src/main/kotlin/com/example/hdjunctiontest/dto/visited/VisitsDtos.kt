package com.example.hdjunctiontest.dto.visited

import com.example.hdjunctiontest.domain.entity.visit.Visits
import java.time.Instant
import kotlin.String

data class VisitsListDto(
    val visitedDate: Instant,
    val receiptStatusCode: String,
    val medicalSubjectCode: String,
    val medicalTypeCode: String,
) {
    companion object {
        fun of(entity: Visits): VisitsListDto {
            with(entity) {
                return VisitsListDto(
                    visitedDate = visitedDate,
                    receiptStatusCode = receiptStatusCode,
                    medicalSubjectCode = medicalSubjectCode,
                    medicalTypeCode = medicalTypeCode,
                )
            }
        }
    }
}