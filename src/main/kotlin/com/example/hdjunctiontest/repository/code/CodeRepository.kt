package com.example.hdjunctiontest.repository.code

import com.example.hdjunctiontest.domain.entity.code.Code
import com.example.hdjunctiontest.domain.entity.code.CodeGroup
import com.example.hdjunctiontest.dto.code.CodeDto
import com.example.hdjunctiontest.type.CodeGroupType
import org.springframework.data.jpa.repository.JpaRepository

interface CodeRepository : JpaRepository<Code, Long> {
    fun findAllByCodeGroup(codeGroup: String): List<Code>

    fun findByCodeAndCodeGroup(code:String, codeGroupType: String): Code?
}