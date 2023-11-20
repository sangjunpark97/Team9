package com.example.team9.Schedule

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.databinding.FragmentScheduleBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Schedule(var text1: String, var text2: String = "", var text3: String = "", var text4: String = "", var text5:String = ""
               , var text6: String = "", var text7: String = "", var text8: String = "", var text9: String = "", var text10: String = "")
class Color(var text1_color: String = "White", var text2_color: String = "White", var text3_color: String = "White"
            , var text4_color: String = "White", var text5_color: String = "White", var text6_color: String = "White"
            , var text7_color: String = "White", var text8_color: String = "White", var text9_color: String = "White"
            , var text10_color: String = "White")
private var schedule = arrayOf(
    Schedule(" ","9:00" ,"10:00","11:00","12:00","13:00",
    "14:00","15:00","16:00","17:00"),
    Schedule("월"),
    Schedule("화"),
    Schedule("수"),
    Schedule("목"),
    Schedule("금"),
    Schedule("토"),
    Schedule("일")
)
private var color = arrayOf(Color(), Color(),Color(), Color(),Color(), Color(),Color(), Color())

class ScheduleFragment() : Fragment() {
    private lateinit var binding: FragmentScheduleBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        binding.recSchedule.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recSchedule.adapter = ScheduleAdapter(schedule, color)


        binding.ActionBtn.setOnClickListener{
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, "bottomFrag")
        }

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateSchedule(newText: String, day: BooleanArray, startTime: Int, endTime: Int, Color: String) {
        val lectureTime = endTime - startTime
        for(i in 0..6) {
            if (day[i]) {
                for (time in startTime until endTime) {
                    when (time) {
                        9 -> {
                            schedule[i + 1].text2 = newText
                            color[i + 1].text2_color = Color
                        }
                        10 -> {
                            schedule[i + 1].text3 = newText
                            color[i + 1].text3_color = Color
                        }
                        11 -> {
                            schedule[i + 1].text4 = newText
                            color[i + 1].text4_color = Color
                        }
                        12 -> {
                            schedule[i + 1].text5 = newText
                            color[i + 1].text5_color = Color
                        }
                        13 -> {
                            schedule[i + 1].text6 = newText
                            color[i + 1].text6_color = Color
                        }
                        14 -> {
                            schedule[i + 1].text7 = newText
                            color[i + 1].text7_color = Color
                        }
                        15 -> {
                            schedule[i + 1].text8 = newText
                            color[i + 1].text8_color = Color
                        }
                        16 -> {
                            schedule[i + 1].text9 = newText
                            color[i + 1].text9_color = Color
                        }
                        17 -> {
                            schedule[i + 1].text10 = newText
                            color[i + 1].text10_color = Color
                        }
                    }

                }
            }
        }
        binding.recSchedule.adapter = ScheduleAdapter(schedule, color)
        binding.recSchedule.adapter?.notifyDataSetChanged()


    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScheduleFragment().apply {

            }
    }
}