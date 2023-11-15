package com.example.team9

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.FragmentScheduleBinding
import com.example.team9.databinding.ScheduleItemBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class ScheduleAdapter(val schedule: Array<String>) : RecyclerView.Adapter<ScheduleAdapter.Holder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun getItemCount(): Int = schedule.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(schedule[position])
    }



      class Holder(private val binding: ScheduleItemBinding) : RecyclerView.ViewHolder(binding.root) {
         fun bind(schedule: String) {
             if(schedule=="시간") {
                 binding.timeTable2.text = "9:00"
                 binding.timeTable3.text = "10:00"
                 binding.timeTable4.text = "11:00"
                 binding.timeTable5.text = "12:00"
                 binding.timeTable6.text = "13:00"
                 binding.timeTable7.text = "14:00"
                 binding.timeTable8.text = "15:00"
                 binding.timeTable9.text = "16:00"
                 binding.timeTable10.text = "17:00"
             }
             else {
                 binding.timeTable1.text = schedule
             }


             binding.root.setOnClickListener{

                 val builder = AlertDialog.Builder(binding.root.context)
                 builder.setMessage("to do list 연동")
                 builder.setPositiveButton("확인") { dialog, _ ->
                     dialog.dismiss()
                 }
                 val dialog = builder.create()
                 dialog.show()
             }
         }
    }


}