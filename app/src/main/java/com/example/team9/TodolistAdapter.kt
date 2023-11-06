package com.example.team9

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.TodoitemBinding

class TodolistAdapter: RecyclerView.Adapter<TodolistAdapter.Holder>(){//홀더클래스를 상속(뷰홀더패턴)
    //뷰홀더패턴? 각 뷰 객체를 뷰 홀더에 보관하여 반복적인 메소드 호출을 줄여 속도를 개선하는 패턴
    private val testArray: List<String> = listOf("객프과제","컴구발표","이산수학과제","알고리즘과제","ad발표","개발공부")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodolistAdapter.Holder {
        return Holder(
            // ItemReviewPhotoBinding 클래스로 만들어지는 binding 인스턴스를 사용하도록 변경
            TodoitemBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }
    //어댑터는 아이템뷰를 생성하고 데이터를 바인딩해준다.
    //바인딩은 아이템뷰에 알맞는 데이터순서대로 넣어주는 것을 말한다.
    //레이아웃 매니저는 어댑터에 생성한 아이템뷰의 배치를 결정한다.
    //

    override fun onBindViewHolder(holder: TodolistAdapter.Holder, position: Int) {
        holder.bind(testArray[position])
    }

    override fun getItemCount(): Int = testArray.size   //return testArray.size

    class Holder(private val binding: TodoitemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: String) {
            binding.checkBox.text = item
            binding.checkBox.setOnCheckedChangeListener { a, b ->
                if (a.isChecked) {

                } else {

                }
            }
        }
    }
}