package com.example.team9

interface JWAData {
    data class appData(
        val subject: String?,
        val todo: Todo?,
        val classTime: String?,
        val classRoom: String?,
        val teacher: String?,
        val scheduleMemo: String?
    )

    data class Todo(
        val title: String?,
        val deadline: String?,
        val todoMemo: String?
    )
}