package com.example.hdjunctiontest.application.visit

import com.example.hdjunctiontest.model.TypeModel
import com.example.hdjunctiontest.model.visit.VisitTypeResponse
import com.example.hdjunctiontest.service.code.CodeService
import com.example.hdjunctiontest.service.visit.VisitService
import com.example.hdjunctiontest.type.CodeGroupType
import org.springframework.stereotype.Service

@Service
class VisitApplication(
    private val visitService: VisitService,
    private val codeService: CodeService,
) {
    fun getType(): VisitTypeResponse =
        VisitTypeResponse(
            receiptStatusType = codeService.findAllByCodeGroup(CodeGroupType.RECEIPT_STATUS)
                .map { TypeModel(it.code, it.codeName) },
            medicalSubjectType = codeService.findAllByCodeGroup(CodeGroupType.MEDICAL_SUBJECT)
                .map { TypeModel(it.code, it.codeName) },
            medicalType = codeService.findAllByCodeGroup(CodeGroupType.MEDICAL_TYPE)
                .map { TypeModel(it.code, it.codeName) },
        )

}