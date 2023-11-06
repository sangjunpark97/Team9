package com.example.team9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.databinding.FragmentScheduleBinding
import com.example.team9.databinding.ScheduleItemBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Schedule(val time:String, val mon: String, val tue: String, val wed: String, val thu:String, val fri: String,
               val sat: String, val sun: String)


class ScheduleFragment() : Fragment() {

    val schedule = arrayOf(
        Schedule(" ","월" ,"화","수","목","금","토","일") ,
        Schedule("9:00"," " ," "," "," "," "," "," ") ,
        Schedule("10:00"," " ," "," "," "," "," "," ") ,
        Schedule("11:00"," " ," "," "," "," "," "," ") ,
        Schedule("12:00"," " ," "," "," "," "," "," ") ,
        Schedule("13:00"," " ," "," "," "," "," "," ") ,
        Schedule("14:00"," " ," "," "," "," "," "," ") ,
        Schedule("15:00"," " ," "," "," "," "," "," ") ,
        Schedule("16:00"," " ," "," "," "," "," "," ") ,
        Schedule("17:00"," " ," "," "," "," "," "," ")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentScheduleBinding.inflate(inflater, container, false)
        binding.recSchedule.layoutManager = LinearLayoutManager(requireContext())
        binding.recSchedule.adapter = ScheduleAdapter(schedule)
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ScheduleFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}