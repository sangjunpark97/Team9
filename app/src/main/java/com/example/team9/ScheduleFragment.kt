package com.example.team9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.team9.databinding.FragmentScheduleBinding
import com.example.team9.databinding.ScheduleItemBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Schedule(var text1:String, var text2: String, var text3: String, var text4: String, var text5:String, var text6: String,
               var text7: String, var text8: String, var text9: String, var text10: String)


class ScheduleFragment() : Fragment() {
    private lateinit var binding: FragmentScheduleBinding
    var schedule = arrayOf(Schedule(" ","9:00" ,"10:00","11:00","12:00","13:00",
        "14:00","15:00","16:00","17:00"),
        Schedule("월"," " ," "," "," "," ", " "," "," "," "),
        Schedule("화"," " ," "," "," "," ", " "," "," "," "),
        Schedule("수"," " ," "," "," "," ", " "," "," "," "),
        Schedule("목"," " ," "," "," "," ", " "," "," "," "),
        Schedule("금"," " ," "," "," "," ", " "," "," "," "),
        Schedule("토"," " ," "," "," "," ", " "," "," "," "),
        Schedule("일"," " ," "," "," "," ", " "," "," "," ")
        )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        binding.recSchedule.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recSchedule.adapter = ScheduleAdapter(schedule)



        binding.ActionBtn.setOnClickListener{
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, "bottomFrag")
        }
        return binding.root
    }

    fun updateSchedule(position: Int, newText: String) {
        schedule[position].text3 = newText
        binding.recSchedule.adapter?.notifyDataSetChanged()
    }
    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScheduleFragment().apply {

            }
    }
}