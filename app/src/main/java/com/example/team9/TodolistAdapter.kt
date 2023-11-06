package com.example.team9

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.TodoitemBinding

class TodolistAdapter: RecyclerView.Adapter<TodolistAdapter.ViewHolder>(){
    private val testArray: List<String> = listOf("test1","test2","test3","test4","test5","test6")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodolistAdapter.ViewHolder {
        return ViewHolder(
            // ItemReviewPhotoBinding 클래스로 만들어지는 binding 인스턴스를 사용하도록 변경
            TodoitemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: TodolistAdapter.ViewHolder, position: Int) {
        holder.bind(testArray[position])
    }

    override fun getItemCount(): Int = testArray.size

    inner class ViewHolder(private val binding: TodoitemBinding) :
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