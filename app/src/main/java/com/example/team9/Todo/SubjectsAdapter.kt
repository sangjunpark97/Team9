package com.example.team9.TimeTable

import android.R.attr.data
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.CSubject
import com.example.team9.databinding.SubjectItemBinding


class SubjectsAdapter(var subjects: MutableList<CSubject> = mutableListOf()) : RecyclerView.Adapter<SubjectsAdapter.Holder>() {
    interface OnItemClickListener {
        fun onItemClick(itemValue: CSubject?)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = SubjectItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(subjects[position])
        holder.bindButton(subjects[position])
    }

    override fun getItemCount(): Int = subjects.size

    fun updateData(newTimeTables: List<CSubject>) {
        subjects.clear()
        subjects.addAll(newTimeTables)
        notifyDataSetChanged()
    }

    inner class Holder(private val binding: SubjectItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(subject: CSubject){
            binding.txtSubject.text = subject.name
        }

        fun bindButton(subject: CSubject) {
            binding.checkBoxBtn.setOnClickListener {
                if (listener != null) {
//                    Log.d("좌","$name")
                    // 인터페이스를 통해 값 전달
                    listener?.onItemClick(subject)
                }
            }
        }
    }
}