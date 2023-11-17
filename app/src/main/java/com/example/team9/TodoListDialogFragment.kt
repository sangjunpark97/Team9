package com.example.team9

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.team9.databinding.FragmentTodoListDialogBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TodoListDialogFragment : DialogFragment() {
    private lateinit var todoViewModel: TodoViewModel

    private var param1: String? = null
    private var param2: String? = null

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
        todoViewModel = ViewModelProvider(requireActivity()).get(TodoViewModel::class.java)
        val binding = FragmentTodoListDialogBinding.inflate(inflater, container, false)

        binding.buttonAdd.setOnClickListener {
            val TextTodo=binding.TextTodo.text.toString()
            val Subject=binding.subject.text?.toString()
            val duedate=binding.duedate.text?.toString()


            val db=Firebase.database
            val todoref=db.getReference("5")
            todoref.child("todo").push().setValue(JWAData.Todo(TextTodo,Subject,duedate))
            todoViewModel.addTodo(TextTodo,duedate)


            dismiss()
        }
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TodoListDialogFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}