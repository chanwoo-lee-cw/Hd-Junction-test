package com.example.hdjunctiontest.type

enum class PatientSearchType(val value: String) {
    NAME("이름"),
    PATIENT_CODE("환자 등록 번호"),
    BIRTH_DAY("생년 월일");


    companion object {
        val typeEntries: List<PatientSearchType>
            get() = PatientSearchType.entries
    }

}

enum class GenderType(val value: String) {
    MALE("남자"),
    FEMALE("여자");

    companion object {
        val typeEntries: List<GenderType>
            get() = GenderType.entries
    }

}