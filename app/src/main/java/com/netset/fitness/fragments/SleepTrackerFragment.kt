package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.TimelineStepsAdapter
import com.netset.fitness.adapters.TodayScheduleAdapter
import com.netset.fitness.databinding.FragmentSleepTrackerBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.TimelineStepsDataItems
import com.netset.models.TodayScheduleDataItems


class SleepTrackerFragment : Fragment() {
   private lateinit var binding:FragmentSleepTrackerBinding
    private var todayScheduleList:ArrayList<TodayScheduleDataItems> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentSleepTrackerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)


        binding.sleepTrackerToolbar.fragmentsText.text="Sleep Tracker"

        binding.checkIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,SleepScheduleFragment(),R.id.dashboardContainerView,true)
        }

        todayScheduleDataShow()

    }

    private fun todayScheduleDataShow() {
        todayScheduleList.clear()
        todayScheduleList.add(TodayScheduleDataItems(R.drawable.icon_bed,"Bedtime,","09:00pm","in 6hours 22minutes"))
        todayScheduleList.add(TodayScheduleDataItems(R.drawable.alarm_clock_icon,"Alarm,","05:10am","in 14hours 30minutes"))
        binding.todayScheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val todayScheduleAdapter = TodayScheduleAdapter(requireContext(),todayScheduleList)
        binding.todayScheduleRecyclerView.adapter = todayScheduleAdapter
    }
}