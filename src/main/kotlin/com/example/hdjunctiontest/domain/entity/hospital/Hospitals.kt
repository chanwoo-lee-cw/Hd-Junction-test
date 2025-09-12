package com.example.hdjunctiontest.domain.entity.hospital

import com.example.hdjunctiontest.domain.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction
import java.math.BigInteger
import java.time.Instant


@Entity
@DynamicInsert
@DynamicUpdate
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "update hospitals set deleted_at = CURRENT_TIMESTAMP where id = ?")
@Table(name = "hospitals")
class Hospitals(
    @Column(nullable = false, name = "name", length = 45)
    val name: String,


    @Column(nullable = false, name = "institution_code", length = 20)
    val institutionCode: String,


    @Column(nullable = false, name = "owner_name", length = 10)
    val ownerName: String,

    @Column(name = "deleted_at")
    var deletedAt: Instant? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
) : BaseEntity() {

    fun delete() {
        this.deletedAt = Instant.now()
    }
}