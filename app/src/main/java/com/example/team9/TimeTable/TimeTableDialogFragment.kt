package com.example.team9.TimeTable

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.team9.CTimeTable
import com.example.team9.R
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentTimeTableDialogBinding

class TimeTableDialogFragment : DialogFragment() {
    val viewModel: TimeTableViewModel by activityViewModels()
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_todo_list_dialog)

        val width = 1050
        val height = 500
        dialog.window?.setLayout(width, height)

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTimeTableDialogBinding.inflate(inflater, container, false)

        binding.btnOk.setOnClickListener {
            var name :String = binding.editTTName.text.toString()
            viewModel.TimeTable.value?.timeTable?.add(CTimeTable(name))

            dismiss()
        }

        binding.btnCancel.setOnClickListener {
            dismiss()
        }

        return binding.root
    }
}