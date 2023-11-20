package com.example.team9.Todo

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.team9.CSubject
import com.example.team9.CToDo
import com.example.team9.R
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentTodoListDialogBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TodoListDialogFragment : DialogFragment() {
    val viewModel: TimeTableViewModel by activityViewModels()
    var binding: FragmentTodoListDialogBinding? = null
    var selectSubject: CSubject? = null  //초기화

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = Dialog(requireContext())
        dialog.setContentView(R.layout.fragment_todo_list_dialog)
        viewModel.selectSubject(CSubject(""))
        viewModel.selectTodo(CSubject(""))
        selectSubject = null
        val width = 1050
        val height = 1000
        dialog.window?.setLayout(width, height)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTodoListDialogBinding.inflate(inflater, container, false)
        binding?.btnSelect?.setOnClickListener {
            val subjectDialogFragment = SelectSubjectDialogFragment()
            subjectDialogFragment.show(childFragmentManager, "subject")
        }

        viewModel.selectSubject.observe(this, Observer {
            if (it != CSubject("")) {
                selectSubject = it
                binding?.editTextText?.setText(selectSubject?.name)
            }
        })

        if (binding?.editTextText?.text.toString().isNotEmpty()) {
            binding?.editTextText?.setText("")
        }

        binding?.buttonAdd?.setOnClickListener {
            selectSubject?.toDoList?.add(
                CToDo(binding?.TextTodo?.text.toString(),
                binding?.duedate?.text?.toString() ?: "")
            )
            selectSubject?.let { it1 -> viewModel.selectTodo(it1) }
            dismiss()
        }

        binding?.buttonCancel?.setOnClickListener {
            dismiss()
        }
        return binding?.root
    }
}