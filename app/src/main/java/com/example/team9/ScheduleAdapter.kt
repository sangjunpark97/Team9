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

class ScheduleAdapter(val schedule: Array<Schedule>) : RecyclerView.Adapter<ScheduleAdapter.Holder>(){
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

             binding.time.text = schedule.time
             binding.mon.text = schedule.mon
             binding.tue.text = schedule.tue
             binding.wed.text = schedule.wed
             binding.thu.text = schedule.thu
             binding.fri.text = schedule.fri
             binding.sat.text = schedule.sat
             binding.sun.text = schedule.sun


             binding.root.setOnClickListener{
                 val bottomSheetFragment = BottomSheetFragment()



//                 val builder = AlertDialog.Builder(binding.root.context)
//                 builder.setMessage("시간표 추가 작업") // 원하는 메시지로 변경
//                 builder.setPositiveButton("확인") { dialog, _ ->
//                     dialog.dismiss()
//                 }
//                 val dialog = builder.create()
//                 dialog.show()
             }
         }
    }


}