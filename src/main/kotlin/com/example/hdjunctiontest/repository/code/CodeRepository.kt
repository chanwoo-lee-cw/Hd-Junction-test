package com.example.hdjunctiontest.repository.code

import com.example.hdjunctiontest.domain.entity.code.Code
import org.springframework.data.jpa.repository.JpaRepository

interface CodeRepository : JpaRepository<Code, Long> {
}