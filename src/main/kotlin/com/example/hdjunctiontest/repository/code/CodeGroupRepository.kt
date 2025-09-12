package com.example.hdjunctiontest.repository.code

import com.example.hdjunctiontest.domain.entity.code.CodeGroup
import org.springframework.data.jpa.repository.JpaRepository

interface CodeGroupRepository : JpaRepository<CodeGroup, Long> {
}