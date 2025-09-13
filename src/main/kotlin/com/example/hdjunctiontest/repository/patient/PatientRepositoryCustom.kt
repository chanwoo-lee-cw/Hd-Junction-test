package com.example.hdjunctiontest.repository.patient

import com.example.hdjunctiontest.domain.entity.patient.QPatients.patients
import com.example.hdjunctiontest.dto.patient.PatientFilterDto
import com.example.hdjunctiontest.dto.patient.PatientsListDto
import com.example.hdjunctiontest.dto.patient.QPatientsListDto
import com.example.hdjunctiontest.type.PatientSearchType
import com.querydsl.core.BooleanBuilder
import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.support.PageableExecutionUtils
import org.springframework.stereotype.Repository

@Repository
interface PatientRepositoryCustom {
    fun findAllByPaging(filter: PatientFilterDto, pageable: Pageable): Page<PatientsListDto>
}


class PatientRepositoryCustomImpl(
    private val queryFactory: JPAQueryFactory
) : PatientRepositoryCustom {

    override fun findAllByPaging(
        filter: PatientFilterDto,
        pageable: Pageable
    ): Page<PatientsListDto> {
        val where = BooleanBuilder().apply {
            filter.searchValue?.let {
                // DB 상황에 따라 match로 변경 필요
                when (filter.searchType) {
                    null -> null
                    PatientSearchType.NAME -> and(patients.name.like(it))
                    PatientSearchType.PATIENT_CODE -> and(patients.patientCode.like(it))
                    PatientSearchType.BIRTH_DAY -> and(patients.patientCode.eq(it))
                }
            }
        }

        val query = queryFactory
            .from(patients)
            .where(where)
            .select(
                QPatientsListDto(
                    patients.name,
                    patients.patientCode,
                    patients.genderCode,
                    patients.birthDay,
                    patients.phoneNumber,
                )
            )

        val result = query
            .offset(pageable.offset)
            .limit(pageable.pageSize.toLong())
            .fetch()

        return PageableExecutionUtils.getPage(
            result, pageable
        ) { query.fetchCount() }
    }

}