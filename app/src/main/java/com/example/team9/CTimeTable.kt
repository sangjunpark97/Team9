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

class CTimeTable {
    val subjects = mutableListOf<CSubject>()

    public fun addSubject(name: String, day: String? = null, place: String? = null, startTime: String? = null, endTime: String? = null, memo: String? = null) {
        val subject = CSubject(name)
        subject.day = day
        subject.place = place
        subject.startTime = startTime
        subject.endTime = endTime
        subject.memo = memo
        subjects.add(subject)
    }

    public fun displayTimeTable() {
        println("Timetable:")
        for (subject in subjects) {
            println("${subject.name}: ${subject.day}, ${subject.place}, ${subject.startTime} - ${subject.endTime}")
            if (subject.memo != null) {
                println("Memo: ${subject.memo}")
            }
            println("TO-DO List:")
            for (toDoItem in subject.toDoList) {
                println("what? : ${toDoItem.what}")
                if (toDoItem.deadline != null) {
                    println("deadline : ${toDoItem.deadline}")
                }
            }
        }
    }
}

//참고

/*

fun main() {
    val myTimetable = TimeTable()

    myTimetable.addSubject("Math", "Monday", "Room A", "09:00 AM", "10:30 AM", "Review chapter 3")
    myTimetable.addSubject("History", "Tuesday", "Room B", "02:00 PM", "03:30 PM", "Bring textbook")
    myTimetable.addSubject("English", "Wednesday", "Room C", "11:30 AM", "01:00 PM")

    myTimetable.subjects[0].toDoList.add("Complete Math homework")
    myTimetable.subjects[0].toDoList.add("Study for Math test")

    myTimetable.subjects[1].toDoList.add("Read history chapter")

    myTimetable.subjects[2].toDoList.add("Prepare for English presentation")
    myTimetable.subjects[2].toDoList.add("Review grammar")

    myTimetable.displayTimeTable()
}

 */