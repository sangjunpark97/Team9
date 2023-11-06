package com.example.team9

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.TodoitemBinding

class TodolistAdapter: RecyclerView.Adapter<TodolistAdapter.Holder>(){//뷰홀더패턴
    //뷰홀더패턴? 각 뷰 객체를 뷰 홀더에 보관하여 반복적인 메소드 호출을 줄여 속도를 개선하는 패턴
    private val testArray: List<String> = listOf("객프과제","컴구발표","이산수학과제","알고리즘과제","ad발표","개발공부")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodolistAdapter.Holder {
        return Holder(
            //홀더 객체를 생성  아이템 뷰를 인플레이트하고 홀더 객체 반환
            TodoitemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }
    //어댑터는 아이템뷰를 생성하고 데이터를 바인딩해준다.
    //바인딩은 아이템뷰에 알맞는 데이터순서대로 넣어주는 것을 말한다.
    //레이아웃 매니저는 어댑터에 생성한 아이템뷰의 배치를 결정한다.
    //

    override fun onBindViewHolder(holder: TodolistAdapter.Holder, position: Int) {
        holder.bind(testArray[position])    //테스트에레이에 position위치에있는 데이터를 홀더와 결합
    }

    override fun getItemCount(): Int = testArray.size   //return testArray.size
    //리사이클러 뷰에 표시할 아이템 개수

    class Holder(private val binding: TodoitemBinding) : //각 아이템뷰의 레이아웃 및 내용관리
        RecyclerView.ViewHolder(binding.root) {  //뷰홀더를 나타냄

        fun bind(item: String) {     //뷰홀더에 데이터를 바인딩함 항목에 내역을 text에 저장하고
            binding.checkBox.text = item
            binding.checkBox.setOnCheckedChangeListener { check, notcheck ->  //메서드활용하여 체크박스 상태변화를 알아낸다

            }
        }
    }
}