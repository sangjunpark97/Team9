package com.example.team9


data class Subject(val name: String, val day: String, val place: String, val startTime: String, val endTime: String)

class TimeTable {
    val subjects = mutableListOf<Subject>()  // 수업 목록을 저장할 리스트

    fun addSubject(name: String, day: String, place: String, startTime: String, endTime: String) {
        val subject = Subject(name, day, place, startTime, endTime)
        subjects.add(subject)
    }

    fun displayTimeTable() {
        println("Timetable:")
        for (subject in subjects) {
            println("${subject.name}: ${subject.day}, ${subject.place}, ${subject.startTime} - ${subject.endTime}")
        }
    }
}