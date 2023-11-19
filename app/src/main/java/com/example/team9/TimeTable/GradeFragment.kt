package com.example.team9.TimeTable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentGradeBinding

class GradeFragment : Fragment() {

    val viewModel: TimeTableViewModel by activityViewModels()
    var binding : FragmentGradeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGradeBinding.inflate(inflater, container, false)

        binding?.btnAct?.setOnClickListener {
            val timeTableDialogFragment = TimeTableDialogFragment()
            timeTableDialogFragment.show(childFragmentManager, "timeTable")
        }

        // Inflate the layout for this fragment
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var timetablesAdapter = TimetablesAdapter()
        binding?.recTimetable?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recTimetable?.adapter = timetablesAdapter

        viewModel.TimeTable.observe(viewLifecycleOwner) {
            it?.timeTable?.let { newTimeTables ->
                timetablesAdapter?.updateData(newTimeTables)
                timetablesAdapter?.notifyDataSetChanged()
            }
        }
    }
}