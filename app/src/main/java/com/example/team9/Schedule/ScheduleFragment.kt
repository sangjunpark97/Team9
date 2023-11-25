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

class Line(val text1: String, var text2: String = "", var text3: String = "", var text4: String = "", var text5:String = ""
           , var text6: String = "", var text7: String = "", var text8: String = "", var text9: String = "", var text10: String = "")
class Color(val text1Color: String = "White", var text2Color: String = "White", var text3Color: String = "White"
            , var text4Color: String = "White", var text5Color: String = "White", var text6Color: String = "White"
            , var text7Color: String = "White", var text8Color: String = "White", var text9Color: String = "White"
            , var text10Color: String = "White")
private var lines = arrayOf(
    Line(" ","9:00" ,"10:00","11:00","12:00","13:00",
    "14:00","15:00","16:00","17:00"),
    Line("월"),
    Line("화"),
    Line("수"),
    Line("목"),
    Line("금"),
    Line("토"),
    Line("일")
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
        binding.recSchedule.adapter = ScheduleAdapter(lines, color)


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
                            lines[i + 1].text2 = newText
                            color[i + 1].text2Color = Color
                        }
                        10 -> {
                            lines[i + 1].text3 = newText
                            color[i + 1].text3Color = Color
                        }
                        11 -> {
                            lines[i + 1].text4 = newText
                            color[i + 1].text4Color = Color
                        }
                        12 -> {
                            lines[i + 1].text5 = newText
                            color[i + 1].text5Color = Color
                        }
                        13 -> {
                            lines[i + 1].text6 = newText
                            color[i + 1].text6Color = Color
                        }
                        14 -> {
                            lines[i + 1].text7 = newText
                            color[i + 1].text7Color = Color
                        }
                        15 -> {
                            lines[i + 1].text8 = newText
                            color[i + 1].text8Color = Color
                        }
                        16 -> {
                            lines[i + 1].text9 = newText
                            color[i + 1].text9Color = Color
                        }
                        17 -> {
                            lines[i + 1].text10 = newText
                            color[i + 1].text10Color = Color
                        }
                    }

                }
            }
        }
        binding.recSchedule.adapter = ScheduleAdapter(lines, color)
        binding.recSchedule.adapter?.notifyDataSetChanged()


    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScheduleFragment().apply {

            }
    }
}