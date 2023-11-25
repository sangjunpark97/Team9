package com.example.team9.Schedule

import android.app.AlertDialog
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.ScheduleItemBinding

class ScheduleAdapter(var line: Array<Line>, var color: Array<Color>) : RecyclerView.Adapter<ScheduleAdapter.Holder<Any?>>(){


    fun getItem(position: Int): Line {
        return line[position]
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder<Any?> {
        val binding = ScheduleItemBinding.inflate(LayoutInflater.from(parent.context))
        return Holder(binding)
    }

    override fun getItemCount(): Int = line.size


    override fun onBindViewHolder(holder: Holder<Any?>, position: Int) {

        holder.bind(line[position], color[position])

    }





      class Holder<Drawable>(val binding: ScheduleItemBinding) : RecyclerView.ViewHolder(binding.root) {

         fun bind(line: Line, color: Color) {

             binding.timeTable1.text = line.text1
             binding.timeTable1.background = shape(getColorByColorName(color.text1_color))
             binding.timeTable2.text = line.text2
             binding.timeTable2.background = shape(getColorByColorName(color.text2_color))
             binding.timeTable3.text = line.text3
             binding.timeTable3.background = shape(getColorByColorName(color.text3_color))
             binding.timeTable4.text = line.text4
             binding.timeTable4.background = shape(getColorByColorName(color.text4_color))
             binding.timeTable5.text = line.text5
             binding.timeTable5.background = shape(getColorByColorName(color.text5_color))
             binding.timeTable6.text = line.text6
             binding.timeTable6.background = shape(getColorByColorName(color.text6_color))
             binding.timeTable7.text = line.text7
             binding.timeTable7.background = shape(getColorByColorName(color.text7_color))
             binding.timeTable8.text = line.text8
             binding.timeTable8.background = shape(getColorByColorName(color.text8_color))
             binding.timeTable9.text = line.text9
             binding.timeTable9.background = shape(getColorByColorName(color.text9_color))
             binding.timeTable10.text = line.text10
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

                  else -> android.graphics.Color.parseColor("#FFFFFF")
              }
          }


    }





}