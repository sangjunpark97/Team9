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
import com.example.team9.CTimeTable
import com.example.team9.CToDo
import com.example.team9.JWAData
import com.example.team9.R
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentTodoListDialogBinding
import com.google.firebase.database.FirebaseDatabase




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
            if (it != CSubject("")) {  //비어있지않으면
                selectSubject = it
                binding?.editTextText?.setText(selectSubject?.name)
            }
        })

        if (binding?.editTextText?.text.toString().isNotEmpty()) {
            binding?.editTextText?.setText("")
        }

        binding?.buttonAdd?.setOnClickListener {
            writeDataToFirebase()
            selectSubject?.toDoList?.add(
                CToDo(binding?.TextTodo?.text.toString(),
                binding?.duedate?.text?.toString() ?: "")
            )
            selectSubject?.let { it1 -> viewModel.selectTodo(it1) }
            //해당객체를 it1으로 받아와서 null이 아닌경우에만 실행
            dismiss()
        }
        binding?.buttonCancel?.setOnClickListener {

            dismiss()
        }
        return binding?.root
    }

    private fun writeDataToFirebase() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("todos")
        // Firebase에 데이터 쓰기
        val todoData = JWAData.Todo(
            selectSubject?.name,
            binding?.duedate?.text?.toString() ?: "",
            binding?.TextTodo?.text.toString()
        )

        // 쓰기 작업
        myRef.child(selectSubject?.name ?: "").push().setValue(todoData)
    }
}