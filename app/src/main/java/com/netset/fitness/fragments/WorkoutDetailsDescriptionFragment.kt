package com.netset.fitness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker.OnValueChangeListener
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.TimeLineAdapter
import com.netset.fitness.databinding.FragmentWorkoutDetailsDescriptionBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.TimeLineDataItems


class WorkoutDetailsDescriptionFragment : Fragment() {
  private lateinit var binding:FragmentWorkoutDetailsDescriptionBinding
    private var list:ArrayList<TimeLineDataItems> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutDetailsDescriptionBinding.inflate(layoutInflater,container,false)
        (activity as DashBoardActivity?)!!.showHideBottomBar(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)


        binding.saveButton.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                WorkoutScheduleFragment(),
                R.id.dashboardContainerView,true)
        }

        timeLineDataShow()

        binding.caloriesBurnPicker.maxValue = 4
        binding.caloriesBurnPicker.minValue = 0
        val pickerVals = arrayOf<String>("450 Calories Burn", "450 Calories Burn", "450 Calories Burn", "450 Calories Burn", "450 Calories Burn")
        binding.caloriesBurnPicker.displayedValues = pickerVals


        binding.caloriesBurnPicker.setOnValueChangedListener(OnValueChangeListener { numberPicker, i, i1 ->
            val valuePicker1: Int = binding.caloriesBurnPicker.value
        })
        binding.timesPicker.maxValue = 4
        binding.timesPicker.minValue = 0
        val  timesPicker = arrayOf<String>("1", "2", "3", "4", "5")
        binding.timesPicker.displayedValues = timesPicker

        binding.timesPicker.setOnValueChangedListener(OnValueChangeListener { numberPicker, i, i1 ->
            val valuePicker1: Int = binding.caloriesBurnPicker.value
        })



    }

    private fun timeLineDataShow() {
        list.clear()
        list.add(TimeLineDataItems("01","Spread Your Arms","To make the gestures feel more relaxed, stretch your arms as you start this movement. No bending of hands."))
        list.add(TimeLineDataItems("02","Rest at The Toe","The basis of this movement is jumping. Now, what needs to be considered is that you have to use the tips of your feet"))
        list.add(TimeLineDataItems("03","Adjust Foot Movement","Jumping Jack is not just an ordinary jump. But, you also have to pay close attention to leg movements."))
        binding.timelineRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val trainingAdapter = TimeLineAdapter(requireContext(),list)
        binding.timelineRecyclerView.adapter = trainingAdapter
    }
}