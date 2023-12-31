package com.netset.fitness.fragments

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.SleepScheduleAdapter
import com.netset.fitness.adapters.YourScheduleAdapter
import com.netset.fitness.databinding.FragmentSleepScheduleBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.SleepScheduleDataItems
import com.netset.models.YourScheduleDataItems
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class SleepScheduleFragment : Fragment() {

    private lateinit var binding:FragmentSleepScheduleBinding

    private var yourScheduleList:ArrayList<YourScheduleDataItems> = ArrayList()
    private var sleepScheduleList:ArrayList<SleepScheduleDataItems> = ArrayList()


    private val calendar: Calendar = Calendar.getInstance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding=FragmentSleepScheduleBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),R.color.white)


        binding.sleepScheduleToolbar.fragmentsText.text="Sleep Schedule"

        binding.hoursMinutesText.text = Html.fromHtml("<b>8</b>hours <b>30</b>minutes")

        val shader: Shader = LinearGradient(
            0f,
            0f,
            binding.hoursMinutesText.paint.measureText(binding.hoursMinutesText.text.toString()),
            binding.hoursMinutesText.textSize,
            intArrayOf(ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.hoursMinutesText.paint.shader = shader


        binding.sleepScheduleToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.addIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                AddAlarmFragment(),R.id.dashboardContainerView,true)
        }
        updateCalendarData()
        todayScheduleDataShow()
        sleepScheduleDataShow()
    }

    private fun sleepScheduleDataShow() {
        sleepScheduleList.clear()
        sleepScheduleList.add(SleepScheduleDataItems(R.drawable.icon_bed,"Bedtime,","09:00pm","in 6hours 22minutes"))
        sleepScheduleList.add(SleepScheduleDataItems(R.drawable.alarm_clock_icon,"Alarm,","05:10am","in 14hours 30minutes"))
        binding.sleepScheduleRecyclerView.setHasFixedSize(true)
        binding.sleepScheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val sleepScheduleAdapter = SleepScheduleAdapter(requireContext(), sleepScheduleList)
        binding.sleepScheduleRecyclerView.adapter = sleepScheduleAdapter
    }

    private fun todayScheduleDataShow() {
        binding.todayScheduleRecyclerView.setHasFixedSize(true)
        binding.todayScheduleRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        val adapter = YourScheduleAdapter(requireContext(), yourScheduleList)
        binding.todayScheduleRecyclerView.adapter = adapter
    }

    private fun updateCalendarData() {
        yourScheduleList.clear()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val sdf = SimpleDateFormat("E", Locale.getDefault())

        for (dayOfMonth in 1..daysInMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val dayOfWeek = sdf.format(calendar.time)
            yourScheduleList.add(YourScheduleDataItems(dayOfWeek, dayOfMonth.toString()))
        }
        // Notify the adapter about the changes in data
        binding.todayScheduleRecyclerView.adapter?.notifyDataSetChanged()
    }

}