package com.example.hdjunctiontest.controller.visit

import com.example.hdjunctiontest.application.visit.VisitApplication
import com.example.hdjunctiontest.common.responose.ApiResponse
import io.swagger.v3.oas.annotations.Operation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/api/v1/visit")
class VisitController(
    private val visitApplication: VisitApplication,
) {
    @GetMapping("/types")
    @Operation(summary = "방문 타입 조회")
    fun getTypes() =
        ApiResponse.success(visitApplication.getType())



}