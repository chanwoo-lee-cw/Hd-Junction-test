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
    M("남자"),
    F("여자");
}