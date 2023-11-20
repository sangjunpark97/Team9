package com.example.team9.Schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.activityViewModels
import com.example.team9.TimeTableViewModel
import com.example.team9.databinding.FragmentBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class BottomSheetFragment : BottomSheetDialogFragment() {

    val viewModel: TimeTableViewModel by activityViewModels()

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

        val colorGroup: RadioGroup = binding.colorGroup
        var color: String = "White"
        colorGroup.setOnCheckedChangeListener { _, checkedId ->
            val selectedRadioButton: RadioButton = binding.root.findViewById(checkedId)
            color = when(selectedRadioButton) {
                binding.buttonRed -> "Red"
                binding.buttonBlue -> "Blue"
                binding.buttonBrown -> "Brown"
                binding.buttonGray -> "Gray"
                binding.buttonGreen -> "Green"
                binding.buttonOrange -> "Orange"
                binding.buttonPink -> "Pink"
                else -> "White"
            }
        }


        binding.InputBtn.setOnClickListener {
            val totalText = binding.subName.text.toString() +"\n장소:" + binding.location.text.toString()
            val day = booleanArrayOf(false, false, false, false, false, false, false)
            if(binding.monBtn.isSelected)
                day[0] = true
            if(binding.tueBtn.isSelected)
                day[1] = true
            if(binding.wedBtn.isSelected)
                day[2] = true
            if(binding.thuBtn.isSelected)
                day[3] = true
            if(binding.friBtn.isSelected)
                day[4] = true
            if(binding.satBtn.isSelected)
                day[5] = true
            if(binding.sunBtn.isSelected)
                day[6] = true


            val startTime: Int = when(binding.startTime.text.toString()) {
                "9:00"  -> 9
                "10:00" -> 10
                "11:00" -> 11
                "12:00" -> 12
                "13:00" -> 13
                "14:00" -> 14
                "15:00" -> 15
                "16:00" -> 16
                "17:00" -> 17
                else -> -1
            }
            val endTime: Int = when(binding.endTime.text.toString()) {
                "10:00" -> 10
                "11:00" -> 11
                "12:00" -> 12
                "13:00" -> 13
                "14:00" -> 14
                "15:00" -> 15
                "16:00" -> 16
                "17:00" -> 17
                else -> -1
            }


            val scheduleFragment = parentFragment as? ScheduleFragment
            scheduleFragment?.updateSchedule(totalText, day, startTime, endTime, color)

            var idx : Int? = viewModel.TimeTable.value?.nowIdx

            if (idx != null) {
                viewModel.TimeTable.value?.timeTable?.get(idx)?.addSubject(binding.subName.text.toString())
            }

            dismiss()

        }

        return binding.root
    }
}