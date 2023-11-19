package com.example.team9

data class CToDo(var what: String){
    public var deadline: String? = null
}

data class CSubject(val name: String) {
    public var type: String? = null
    public var credit: Int = -1
    public var grade: Int = -1
    public var day: String? = null
    public var place: String? = null
    public var startTime: String? = null
    public var endTime: String? = null
    public var memo: String? = null

    public val toDoList = mutableListOf<CToDo>()
}

class CTimeTable(val name: String) {
    val subjects = mutableListOf<CSubject>()
    var credit : Int = 0
    var grade : Int = 0

    public fun addSubject(name: String, day: String? = null, place: String? = null, startTime: String? = null, endTime: String? = null, memo: String? = null) {
        val subject = CSubject(name)
        subject.day = day
        subject.place = place
        subject.startTime = startTime
        subject.endTime = endTime
        subject.memo = memo
        subjects.add(subject)
    }
}

class CTimeTables{
    val timeTable = mutableListOf<CTimeTable>().apply {
        // 최소한 하나의 CTimeTable 인스턴스를 추가합니다.
        add(CTimeTable("시간표 1"))
    }

    var nowIdx :Int = 0
}