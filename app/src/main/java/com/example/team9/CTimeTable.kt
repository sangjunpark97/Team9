package com.example.team9

data class CToDo(var what: String){
    var deadline: String? = null
}

data class Subject(val name: String) {
    var type: String? = null
    var credit: Int = -1
    var grade: Int = -1
    var day: String? = null
    var place: String? = null
    var startTime: String? = null
    var endTime: String? = null
    var memo: String? = null

    val toDoList = mutableListOf<String>()
}

class TimeTable {
    val subjects = mutableListOf<Subject>()

    fun addSubject(name: String, day: String, place: String, startTime: String, endTime: String, memo: String? = null) {
        val subject = Subject(name)
        subject.day = day
        subject.place = place
        subject.startTime = startTime
        subject.endTime = endTime
        subject.memo = memo
        subjects.add(subject)
    }

    fun displayTimeTable() {
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