package com.example.hdjunctiontest.dto.visited

import com.example.hdjunctiontest.domain.entity.visit.Visits
import java.time.Instant

data class VisitsListDto(
    val visitedDate: Instant,
    val receiptStatusCode: String
) {
    companion object {
        fun of(entity: Visits): VisitsListDto {
            with(entity) {
                return VisitsListDto(
                    visitedDate = visitedDate,
                    receiptStatusCode = receiptStatusCode,
                )
            }
        }
    }
}