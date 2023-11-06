package com.example.team9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.team9.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }  //안건듬

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTodoListBinding.inflate(inflater, container, false)
        binding.recTodo.layoutManager = LinearLayoutManager(requireContext())
        binding.recTodo.adapter = TodolistAdapter()//리사이클러뷰의 아이디가 recTodo임 리사이클러뷰의 어댑터는 투두리스트어댑터

        return binding.root
    }
}