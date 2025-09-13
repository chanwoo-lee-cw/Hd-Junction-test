package com.example.hdjunctiontest.service.code

import com.example.hdjunctiontest.common.exception.EntityNotFoundException
import com.example.hdjunctiontest.common.exception.ExceptionCode
import com.example.hdjunctiontest.dto.code.CodeDto
import com.example.hdjunctiontest.repository.code.CodeRepository
import com.example.hdjunctiontest.type.CodeGroupType
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class CodeService(
    private val codeRepository: CodeRepository,
) {

    @Cacheable(key = "#codeGroupType", value = ["findAllByCodeGroup"])
    fun findAllByCodeGroup(codeGroupType: CodeGroupType): List<CodeDto> =
        codeRepository.findAllByCodeGroup(codeGroupType.value).map { CodeDto.of(it) }

    @Cacheable(key = "#codeGroupType + ':' + #code", value = ["findByCodeAndCodeGroupType"])
    fun findByCodeAndCodeGroupType(
        code: String,
        codeGroupType: CodeGroupType
    ): CodeDto {
        return CodeDto.of(
            codeRepository.findByCodeAndCodeGroup(code, codeGroupType.value)
                ?: throw EntityNotFoundException(
                    ExceptionCode.NOT_FIND_ENTITY,
                    customMessage = "[CodeService.findByCodeAndCodeGroupType] ${codeGroupType.value} : ${code}, 데이터가 없습니다."
                )
        )
    }


}