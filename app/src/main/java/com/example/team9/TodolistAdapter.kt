package com.example.team9

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.ScheduleItemBinding
import com.example.team9.databinding.TodoitemBinding

class TodolistAdapter (): RecyclerView.Adapter<TodolistAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodolistAdapter.Holder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TodolistAdapter.Holder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int =10

    class Holder(val binding: TodoitemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}