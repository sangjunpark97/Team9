package com.example.team9.TimeTable

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.CSubject
import com.example.team9.CTimeTable
import com.example.team9.databinding.GradeItemBinding
import com.example.team9.databinding.SubjectItemBinding

class SubjectsAdapter(var subjects: MutableList<CSubject> = mutableListOf()) : RecyclerView.Adapter<SubjectsAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = SubjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(subjects[position])
    }

    override fun getItemCount(): Int = subjects.size

    fun updateData(newTimeTables: List<CSubject>) {
        subjects.clear()
        subjects.addAll(newTimeTables)
        notifyDataSetChanged()
    }

    class Holder(private val binding: SubjectItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subject: CSubject){
            binding.txtSubject.text = subject.name
        }
    }
}