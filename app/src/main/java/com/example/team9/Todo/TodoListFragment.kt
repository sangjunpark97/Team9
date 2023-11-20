package com.example.team9.Todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.JWAData
import com.example.team9.TimeTable.SubjectsAdapter
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {
    private lateinit var TimeTableViewModel: TimeTableViewModel
    private lateinit var adapter: TodolistAdapter
    val viewModel: TimeTableViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTodoListBinding.inflate(inflater, container, false)

        binding.todoBtn.setOnClickListener {
            val todoListDialogFragment = TodoListDialogFragment()
            todoListDialogFragment.show(childFragmentManager, "todolist")
        }

        viewModel.selectTodo.observe(viewLifecycleOwner) {
            if (it.name.isNotEmpty()) {
                val todoData = mutableListOf<JWAData.Todo>()
                for (i in it.toDoList) {
                    todoData.add(JWAData.Todo(it.name, i.deadline, i.what))
                }
                var tolistAdapter = TodolistAdapter(todoData)
                binding.recTodo.layoutManager = LinearLayoutManager(requireContext())
                binding.recTodo.adapter = tolistAdapter
            }
        }

        return binding.root
    }
}
