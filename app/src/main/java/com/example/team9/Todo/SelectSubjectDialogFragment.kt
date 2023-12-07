package com.example.team9.Todo

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.CSubject
import com.example.team9.R
import com.example.team9.TimeTable.SubjectsAdapter
import com.example.team9.TimeTable.TimetablesAdapter
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentGradeBinding
import com.example.team9.databinding.FragmentSelectSubjectDialogBinding
import com.example.team9.databinding.FragmentTodoListDialogBinding


class SelectSubjectDialogFragment : DialogFragment(), SubjectsAdapter.OnItemClickListener {

    val viewModel: TimeTableViewModel by activityViewModels()
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
        // 이 프래그먼트를 위한 올바른 레이아웃을 인플레이트합니다.
        val binding = FragmentSelectSubjectDialogBinding.inflate(inflater, container, false)

        var idx: Int = viewModel.TimeTable.value?.nowIdx ?: 0   //선택된 시간표의 인덱스 가져올라고

        var subjectsAdapter = SubjectsAdapter()
        subjectsAdapter.setOnItemClickListener(this)
        binding.recSubjects.layoutManager = LinearLayoutManager(requireContext())
        binding.recSubjects.adapter = subjectsAdapter

        viewModel.TimeTable.value?.timeTable?.get(idx)?.let { subjectsAdapter.updateData(it.subjects) }

        // 인플레이트된 바인딩의 루트 뷰를 반환한다
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onItemClick(itemValue: CSubject?) {
        itemValue?.let {
            Log.d("좌", it.name ?: "Name is null") //
            viewModel.selectSubject(it)
            dismiss()
        }
    }
}