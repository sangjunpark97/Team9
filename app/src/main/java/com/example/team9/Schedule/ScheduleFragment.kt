package com.example.team9.Schedule

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.databinding.FragmentScheduleBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

data class Line(var text1: String = "", var text2: String = "", var text3: String = "", var text4: String = "", var text5:String = ""
                , var text6: String = "", var text7: String = "", var text8: String = "", var text9: String = "", var text10: String = "")
data class Color(var text1Color: String = "White", var text2Color: String = "White", var text3Color: String = "White"
                 , var text4Color: String = "White", var text5Color: String = "White", var text6Color: String = "White"
                 , var text7Color: String = "White", var text8Color: String = "White", var text9Color: String = "White"
                 , var text10Color: String = "White")
var lines = ArrayList<Line>()
var color = ArrayList<Color>()

class ScheduleFragment() : Fragment() {
    private lateinit var binding: FragmentScheduleBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("시간표")
        binding = FragmentScheduleBinding.inflate(inflater, container, false)
        binding.recSchedule.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)


        myRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                lines.clear()
                color.clear()

                for (i in 0 until 8) {
                    val textSnapshot = dataSnapshot.child("text").child(i.toString())
                    val colorSnapshot = dataSnapshot.child("color").child(i.toString())

                    val line = textSnapshot.getValue<Line>()
                    val colorItem = colorSnapshot.getValue<Color>()

                    if (line != null) {
                        lines.add(line)
                    }

                    if (colorItem != null) {
                        color.add(colorItem)
                    }
                }

                binding.recSchedule.adapter = ScheduleAdapter(lines, color)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("Firebase", "Failed to read value for 시간표.", error.toException())
            }
        })




        binding.ActionBtn.setOnClickListener{
            val bottomSheetFragment = BottomSheetFragment()
            bottomSheetFragment.show(childFragmentManager, "bottomFrag")
        }

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateSchedule(newText: String, day: BooleanArray, startTime: Int, endTime: Int, Color: String) {
        val lectureTime = endTime - startTime
        val database = Firebase.database
        val myRef = database.getReference("시간표")

        for (i in 0..6) {
            if (day[i]) {
                for (time in startTime until endTime) {
                    val textKey = "text${time - 7}" // 예: "text2", "text3", ...
                    val colorKey = "text${time - 7}Color" // 예: "text2Color", "text3Color", ...

                    // lines에 데이터 설정
                    myRef.child("text").child(i.toString()).child(textKey).setValue(newText)

                    // color에 데이터 설정
                    myRef.child("color").child(i.toString()).child(colorKey).setValue(Color)
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