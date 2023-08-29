package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.CalendarWorkoutScheduleAdapter
import com.netset.fitness.adapters.WorkoutTimeScheduleAdapter
import com.netset.fitness.databinding.FragmentWorkoutScheduleBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.WorkoutTimeScheduleDataItems
import com.netset.models.CalendarWorkoutScheduleDataItems
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class WorkoutScheduleFragment : Fragment() {

    private lateinit var binding:FragmentWorkoutScheduleBinding
    private var calendarList:ArrayList<CalendarWorkoutScheduleDataItems> = ArrayList()
    private var calendarTimeList:ArrayList<WorkoutTimeScheduleDataItems> = ArrayList()

    private val calendar: Calendar = Calendar.getInstance()




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutScheduleBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)

        binding.workoutScheduleToolbar.fragmentsText.text="Workout Schedule"

        binding.addIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                AddScheduleFragment(), R.id.dashboardContainerView,true)
        }
        updateMonthYearText()
        updateCalendarData()

        binding.leftArrowIcon.setOnClickListener {
            calendar.add(Calendar.MONTH, -1)
            updateMonthYearText()
            updateCalendarData()
        }

        binding.rightArrowIcon.setOnClickListener {
            calendar.add(Calendar.MONTH, 1)
            updateMonthYearText()
            updateCalendarData()

        }

        binding.calendarWorkoutScheduleRecyclerView.setHasFixedSize(true)
        binding.calendarWorkoutScheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val adapter = CalendarWorkoutScheduleAdapter(requireContext(), calendarList)
        binding.calendarWorkoutScheduleRecyclerView.adapter = adapter

        calendarListDataShow()

    }

    private fun calendarListDataShow() {
        calendarTimeList.clear()
        calendarTimeList.add(WorkoutTimeScheduleDataItems("06:00 AM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("07:00 AM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("08:00 AM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("09:00 AM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("10:00 AM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("11:00 AM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("12:00 PM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("02:00 PM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("03:00 PM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("04:00 PM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("05:00 PM"))
        calendarTimeList.add(WorkoutTimeScheduleDataItems("06:00 PM"))

        binding.workoutTimeScheduleRecyclerView.setHasFixedSize(true)
        binding.workoutTimeScheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val timeAdapter = WorkoutTimeScheduleAdapter(requireContext(), calendarTimeList )
        binding.workoutTimeScheduleRecyclerView.adapter = timeAdapter
    }

    private fun  updateTime(){

    }




    private fun updateCalendarData() {
        calendarList.clear()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val sdf = SimpleDateFormat("E", Locale.getDefault())

        for (dayOfMonth in 1..daysInMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val dayOfWeek = sdf.format(calendar.time)
            calendarList.add(CalendarWorkoutScheduleDataItems(dayOfWeek, dayOfMonth.toString()))
        }
        // Notify the adapter about the changes in data
        binding.calendarWorkoutScheduleRecyclerView.adapter?.notifyDataSetChanged()
    }








    private fun updateMonthYearText() {
        val sdf = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
        val formattedDate = sdf.format(calendar.time)
        binding.monthYearText.text = formattedDate


    }

}