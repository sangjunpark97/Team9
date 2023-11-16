package com.example.team9

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.team9.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BottomSheetFragment : BottomSheetDialogFragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentBottomSheetBinding.inflate(inflater,container,false)

        binding.monBtn.setOnClickListener {
            binding.monBtn.isSelected = !binding.monBtn.isSelected
        }
        binding.tueBtn.setOnClickListener {
            binding.tueBtn.isSelected = !binding.tueBtn.isSelected
        }
        binding.wedBtn.setOnClickListener {
            binding.wedBtn.isSelected = !binding.wedBtn.isSelected
        }
        binding.thuBtn.setOnClickListener {
            binding.thuBtn.isSelected = !binding.thuBtn.isSelected
        }
        binding.friBtn.setOnClickListener {
            binding.friBtn.isSelected = !binding.friBtn.isSelected
        }
        binding.satBtn.setOnClickListener {
            binding.satBtn.isSelected = !binding.satBtn.isSelected
        }
        binding.sunBtn.setOnClickListener {
            binding.sunBtn.isSelected = !binding.sunBtn.isSelected
        }

        binding.InputBtn.setOnClickListener {
            val totalText = "333"
            val scheduleFragment = ScheduleFragment()


            scheduleFragment.updateSchedule(3, totalText)
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