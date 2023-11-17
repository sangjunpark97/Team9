package com.example.team9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {
    private lateinit var todoViewModel: TodoViewModel
    private lateinit var adapter: TodolistAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TodolistAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTodoListBinding.inflate(inflater, container, false)
        todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)

        binding.recTodo.layoutManager = LinearLayoutManager(requireContext())
        binding.recTodo.adapter = adapter

        todoViewModel.todoList.observe(viewLifecycleOwner, { todoList ->
            adapter.setTodoList(todoList)
        })

        binding.todoBtn.setOnClickListener {
            val todoListDialogFragment = TodoListDialogFragment()
            todoListDialogFragment.show(childFragmentManager, "todolist")
        }
        return binding.root
    }
}
