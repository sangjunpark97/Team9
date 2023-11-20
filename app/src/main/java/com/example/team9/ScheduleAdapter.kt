package com.example.team9

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.res.ColorStateList
import android.graphics.drawable.GradientDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.ScheduleItemBinding
import androidx.fragment.app.FragmentManager

class ScheduleAdapter(var schedule: Array<Schedule>, var color: Array<Color>) : RecyclerView.Adapter<ScheduleAdapter.Holder<Any?>>(){


    fun getItem(position: Int): Schedule {
        return schedule[position]
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder<Any?> {
        val binding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun getItemCount(): Int = schedule.size


    override fun onBindViewHolder(holder: Holder<Any?>, position: Int) {

        holder.bind(schedule[position], color[position])

    }





      class Holder<Drawable>(val binding: ScheduleItemBinding) : RecyclerView.ViewHolder(binding.root) {

         fun bind(schedule: Schedule, color: Color) {

             binding.timeTable1.text = schedule.text1
             binding.timeTable1.background = shape(getColorByColorName(color.text1_color))
             binding.timeTable2.text = schedule.text2
             binding.timeTable2.background = shape(getColorByColorName(color.text2_color))
             binding.timeTable3.text = schedule.text3
             binding.timeTable3.background = shape(getColorByColorName(color.text3_color))
             binding.timeTable4.text = schedule.text4
             binding.timeTable4.background = shape(getColorByColorName(color.text4_color))
             binding.timeTable5.text = schedule.text5
             binding.timeTable5.background = shape(getColorByColorName(color.text5_color))
             binding.timeTable6.text = schedule.text6
             binding.timeTable6.background = shape(getColorByColorName(color.text6_color))
             binding.timeTable7.text = schedule.text7
             binding.timeTable7.background = shape(getColorByColorName(color.text7_color))
             binding.timeTable8.text = schedule.text8
             binding.timeTable8.background = shape(getColorByColorName(color.text8_color))
             binding.timeTable9.text = schedule.text9
             binding.timeTable9.background = shape(getColorByColorName(color.text9_color))
             binding.timeTable10.text = schedule.text10
             binding.timeTable10.background = shape(getColorByColorName(color.text10_color))






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

          private fun shape(colorByColorName: Int): GradientDrawable {
              val shape = GradientDrawable()
              shape.shape = GradientDrawable.RECTANGLE
              shape.setStroke(1, android.graphics.Color.parseColor("#000000"))
              shape.setColor(colorByColorName) // 배경색
              return shape
          }

          private fun getColorByColorName(colorName: String): Int {
              return when (colorName) {
                  "Red" -> android.graphics.Color.parseColor("#FF5050")
                  "Blue" -> android.graphics.Color.parseColor("#288CFF")
                  "Brown" -> android.graphics.Color.parseColor("#906D3B")
                  "Gray" -> android.graphics.Color.parseColor("#969696")
                  "Green" -> android.graphics.Color.parseColor("#329632")
                  "Orange" -> android.graphics.Color.parseColor("#FFA778")
                  "Pink" -> android.graphics.Color.parseColor("#FFACB7")

                  else -> android.graphics.Color.parseColor("#FFF0F0")
              }
          }


    }





}