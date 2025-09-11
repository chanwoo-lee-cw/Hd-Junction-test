package com.example.hdjunctiontest.domain.entity.patient

import com.example.hdjunctiontest.domain.entity.BaseEntity
import jakarta.persistence.*
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
@SQLDelete(sql = "update patients set deleted_at = CURRENT_TIMESTAMP where id = ?")
@Table(name = "patients")
class Patients(
    @Column(nullable = false, name = "hospital_id")
    val hospitalId: BigInteger,

    @Column(nullable = false, name = "name", length = 45)
    val name: String,

    @Column(nullable = false, name = "patient_code", length = 13)
    val patientCode: String,

    @Column(nullable = false, name = "gender_code", length = 10)
    val genderCode: String,

    @Column(nullable = false, name = "birth_day", length = 10)
    val birthDay: String?,

    @Column(nullable = false, name = "phone_number", length = 20)
    val phoneNumber: String?,

    @Column(name = "deleted_at")
    var deletedAt: Instant? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: BigInteger,
) : BaseEntity() {
    fun delete() {
        this.deletedAt = Instant.now()
    }
}