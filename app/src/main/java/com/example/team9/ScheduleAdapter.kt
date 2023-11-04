package com.example.team9

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.FragmentScheduleBinding
import com.example.team9.databinding.ScheduleItemBinding

class ScheduleAdapter() : RecyclerView.Adapter<ScheduleAdapter.Holder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }

    override fun getItemCount(): Int = 10

    inner class Holder(val binding: ScheduleItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }


}