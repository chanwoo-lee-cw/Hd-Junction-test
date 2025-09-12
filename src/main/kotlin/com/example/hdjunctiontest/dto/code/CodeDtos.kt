package com.example.hdjunctiontest.dto.code

import com.example.hdjunctiontest.domain.entity.code.Code

data class CodeDto(
    val code: String,
    val codeGroup: String,
    val codeName: String,
) {
    companion object {
        fun of(entity: Code): CodeDto {
            with(entity) {
                return CodeDto(
                    code = code,
                    codeGroup = codeGroup,
                    codeName = codeName,
                )
            }
        }
    }
}