package com.example.hdjunctiontest.domain.entity.visit

import com.example.hdjunctiontest.domain.entity.hospital.Hospitals
import com.example.hdjunctiontest.domain.entity.patient.Patients
import jakarta.persistence.*
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.DynamicUpdate
import org.hibernate.annotations.SQLDelete
import org.hibernate.annotations.SQLRestriction
import java.time.Instant

@Entity
@DynamicInsert
@DynamicUpdate
@SQLRestriction("deleted_at IS NULL")
@SQLDelete(sql = "update visits set deleted_at = CURRENT_TIMESTAMP where id = ?")
@Table(name = "visits")
class Visits(
    @Column(nullable = false, name = "hospital_id")
    val hospitalId: Long,

    @Column(nullable = false, name = "patient_id")
    val patientId: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false, insertable = false, updatable = false)
    val patient: Patients? = null,

    @Column(nullable = false, name = "visited_date")
    val visitedDate: Instant,

    @Column(nullable = false, name = "receipt_status_code")
    val receiptStatusCode: String,

    @Column(name = "deleted_at")
    var deletedAt: Instant? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
) {
    fun delete() {
        this.deletedAt = Instant.now()
    }
}