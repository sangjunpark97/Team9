package com.example.team9
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.team9.CTimeTables
import com.example.team9.repository.TimeTableRepository

class TimeTableViewModel : ViewModel() {  //뷰모델 상속

    private val _TimeTables = MutableLiveData<CTimeTables>(CTimeTables())//ctimetables데이터 관리
    val TimeTable : LiveData<CTimeTables> get() = _TimeTables//외부에서참조가능ㅇ

    fun updateTimeTable(newList: List<CTimeTable>) {
        val currentData = _TimeTables.value ?: CTimeTables() //현재 라이브데이터값 가져오기
        //없으면 ctimetables객체생성
        currentData.timeTable.clear()
        currentData.timeTable.addAll(newList) //현재데이터 시간표지우고 채우기
        _TimeTables.value = currentData //데이터업데이트
    }

    /////////////////////////////////좌꺼 건들지말것////////////////////////////////
    //
    //라이브 데이터는 옵저버패턴을 사용하기 때문에, 데이터의 변화를 실시간으로 사용자에게 통지할 수 있다
    private val _selectSubject = MutableLiveData(CSubject(""))
    private val _selectTodo = MutableLiveData(CSubject(""))
    var selectSubject: LiveData<CSubject> = _selectSubject
    var selectTodo: LiveData<CSubject> = _selectTodo

    fun selectSubject(subject: CSubject) {   //받은 subject와 todo로 selectsubject,selecttodo업데이트
        _selectSubject.value = subject
    }

    fun selectTodo(todo: CSubject) {
        _selectTodo.value = todo
    }
}