package com.example.team9

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.ScheduleItemBinding
import androidx.fragment.app.FragmentManager

class ScheduleAdapter(var schedule: Array<Schedule>) : RecyclerView.Adapter<ScheduleAdapter.Holder>(){


    fun getItem(position: Int): Schedule {
        return schedule[position]
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun getItemCount(): Int = schedule.size


    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bind(schedule[position])

    }





      class Holder(private val binding: ScheduleItemBinding) : RecyclerView.ViewHolder(binding.root) {
         fun bind(schedule: Schedule) {
             binding.timeTable1.text = schedule.text1
             binding.timeTable2.text = schedule.text2
             binding.timeTable3.text = schedule.text3
             binding.timeTable4.text = schedule.text4
             binding.timeTable5.text = schedule.text5
             binding.timeTable6.text = schedule.text6
             binding.timeTable7.text = schedule.text7
             binding.timeTable8.text = schedule.text8
             binding.timeTable9.text = schedule.text9
             binding.timeTable10.text = schedule.text10




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