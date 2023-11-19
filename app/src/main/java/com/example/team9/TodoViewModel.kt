package com.example.team9
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.team9.CTimeTables
import com.example.team9.repository.TimeTableRepository

class TimeTableViewModel : ViewModel() {

    private val _TimeTables = MutableLiveData<CTimeTables>(CTimeTables())
    val TimeTable : LiveData<CTimeTables> get() = _TimeTables

    //private val repository = TimeTableRepository()
    init{
        //repository.observeTimeTable(_TimeTables)
    }
}