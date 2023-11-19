package com.example.team9.Todo

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.team9.R
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentTodoListDialogBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TodoListDialogFragment : DialogFragment() {
    val viewModel: TimeTableViewModel by activityViewModels()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_todo_list_dialog)

        val width = 1050
        val height = 1000
        dialog.window?.setLayout(width, height)

        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentTodoListDialogBinding.inflate(inflater, container, false)

        binding.btnSelect.setOnClickListener {
            val subjectDialogFragment = SelectSubjectDialogFragment()
            subjectDialogFragment.show(childFragmentManager, "subject")
        }

        binding.buttonAdd.setOnClickListener {
            val TextTodo=binding.TextTodo.text.toString()
            val duedate=binding.duedate.text?.toString()
        }
        return binding.root
    }
}