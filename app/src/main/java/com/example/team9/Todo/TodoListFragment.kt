package com.example.team9.Todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {
    private lateinit var TimeTableViewModel: TimeTableViewModel
    private lateinit var adapter: TodolistAdapter

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

        return binding.root
    }
}
