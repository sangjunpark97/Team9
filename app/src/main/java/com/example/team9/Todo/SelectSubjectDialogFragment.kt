package com.example.team9.Todo

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.R
import com.example.team9.TimeTable.SubjectsAdapter
import com.example.team9.TimeTable.TimetablesAdapter
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentGradeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SelectSubjectDialogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SelectSubjectDialogFragment : DialogFragment() {

    val viewModel: TimeTableViewModel by activityViewModels()
    var binding : FragmentGradeBinding? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_todo_list_dialog)

        val width = 1050
        val height = 1500
        dialog.window?.setLayout(width, height)

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        var idx :Int = viewModel.TimeTable.value?.nowIdx ?: 0

        var subjectsAdapter = SubjectsAdapter()
        binding?.recTimetable?.layoutManager = LinearLayoutManager(requireContext())
        binding?.recTimetable?.adapter = subjectsAdapter

        viewModel.TimeTable.value?.timeTable?.get(idx)?.let { subjectsAdapter.updateData(it.subjects) }

        return inflater.inflate(R.layout.fragment_select_subject_dialog, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}