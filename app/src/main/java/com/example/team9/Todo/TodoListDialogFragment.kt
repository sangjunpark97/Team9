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
                //라이브데이터 관찰해 비어있지않으면 갖고와서 edittexttext에 설정
            }
        })

        if (binding?.editTextText?.text.toString().isNotEmpty()) {
            binding?.editTextText?.setText("")
            //edittext가 비어있지않으면 초기화시켜줌
        }

        binding?.buttonAdd?.setOnClickListener {
            writeFirebase()//db작성

            selectSubject?.toDoList?.add(   //selectsubject가 지금 Csubject안에 투두리스트에 추가 ctodo객체를
                CToDo(binding?.TextTodo?.text.toString(),
                binding?.duedate?.text?.toString() ?: "")//해당과목의 투두리스트에 새 투두객체 추가
            )
            selectSubject?.let { it1 -> viewModel.selectTodo(it1) }
            //해당객체를 it1으로 받아와서 null이 아닌경우에만 뷰모델 셀렉트투두 호 -> 라이브데이터 업데이트
            dismiss()
        }
        binding?.buttonCancel?.setOnClickListener {

            dismiss()
        }
        return binding?.root
    }

    private fun writeFirebase() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("todos")
        // Firebase에 데이터 쓰기
        val todoData = JWAData.Todo(   //다이얼로그 프래그먼트에서도 CTimeTable 구조 쓰려했으나 실패
            selectSubject?.name,
            binding?.duedate?.text?.toString() ?: "",
            binding?.TextTodo?.text.toString()
        )


        myRef.child(selectSubject?.name ?: "").push().setValue(todoData)
    }
}