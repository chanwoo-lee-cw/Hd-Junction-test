package com.example.hdjunctiontest.domain.entity.code

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate


@Entity
@DynamicInsert
@DynamicUpdate
@Table(name = "code")
class Code (
    @Id
    @Column(nullable = false, name = "code", length = 10)
    val code: String,

    @Column(nullable = false, name = "code_group")
    val codeGroup: String,

    @Column(nullable = false, name = "codeName", length = 10)
    val codeName: String,
)