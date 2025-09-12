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
@Table(name = "code_group")
class CodeGroup(
    @Id
    @Column(nullable = false, name = "code_group")
    val codeGroup: String,

    @Column(nullable = false, name = "code_group_name", length = 10)
    val codeGroupName: String,

    // 10글자로 부족
    @Column(nullable = false, name = "description", length = 63)
    val description: String,
)