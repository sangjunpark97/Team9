package com.example.team9

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.team9.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class BottomSheetFragment : BottomSheetDialogFragment() {

    val viewModel: TimeTableViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentBottomSheetBinding.inflate(inflater,container,false)


        binding.InputBtn.setOnClickListener {
            var name :String = binding.subName.text.toString()
            var place :String = binding.location.text.toString()
            var pro :String = binding.proName.text.toString()

            var idx : Int? = viewModel.TimeTable.value?.nowIdx

            if (idx != null) {
                viewModel.TimeTable.value?.timeTable?.get(idx)?.addSubject(name)
            }

            dismiss()
        }

        return binding.root
    }


    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                BottomSheetFragment().apply {
                    arguments = Bundle().apply {

                    }
                }
    }
}