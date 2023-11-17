package com.example.team9
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoViewModel : ViewModel() {

    private val _todoList = MutableLiveData<List<String>>()
    val todoList: LiveData<List<String>> get() = _todoList

    init {
        // 초기에 빈 목록으로 초기화
        _todoList.value = emptyList()
    }

    fun addTodo(todo: String,date:String?) {
        val currentList = _todoList.value.orEmpty().toMutableList()
        if(date == null){
            currentList.add(todo)
        }
        else{
        currentList.add(todo+"\n"+date) }


        _todoList.value = currentList
    }
}