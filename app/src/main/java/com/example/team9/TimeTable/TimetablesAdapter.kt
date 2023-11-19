package com.example.team9.TimeTable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.CTimeTable
import com.example.team9.databinding.GradeItemBinding

class TimetablesAdapter(var timeTables: MutableList<CTimeTable> = mutableListOf()) : RecyclerView.Adapter<TimetablesAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = GradeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(timeTables[position])
    }

    override fun getItemCount(): Int = timeTables.size

    fun updateData(newTimeTables: List<CTimeTable>) {
        timeTables.clear()
        timeTables.addAll(newTimeTables)
        notifyDataSetChanged()
    }

    class Holder(private val binding: GradeItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(timeTable: CTimeTable){
            binding.txtTimeTable.text = timeTable.name
        }
    }
}