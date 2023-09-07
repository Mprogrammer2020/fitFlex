package com.netset.fitness.fragments

import android.app.DatePickerDialog
import android.content.res.Resources
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.TimePicker
import androidx.core.content.ContextCompat
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentAddScheduleBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddScheduleFragment : Fragment() {
    private lateinit var binding:FragmentAddScheduleBinding
    private val calendar = Calendar.getInstance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddScheduleBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),R.color.white)

        binding.hoursNumberPicker.setIs24HourView(false)
            binding.hoursNumberPicker.hour
            binding.hoursNumberPicker.minute




        binding.addScheduleToolbar.fragmentsText.text="Add Schedule"
        binding.addScheduleToolbar.backIcon.setImageResource(R.drawable.close)

        binding.addScheduleToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.calendarDayText.setOnClickListener {
            showDatePicker()
        }

//        binding.hoursNumberPicker.setOnTimeChangedListener { view, hourOfDay, minute ->
//            val amPm = if (hourOfDay >= 12) "PM" else "AM"
//            val formattedHour = if (hourOfDay > 12) hourOfDay - 12 else hourOfDay
//            binding.hoursNumberPicker.contentDescription = String.format("%02d:%02d $amPm", formattedHour, minute)
//        }


    }

    private fun showDatePicker() {
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, pickedYear, pickedMonth, pickedDay ->
                val pickedCalendar = Calendar.getInstance()
                pickedCalendar.set(pickedYear, pickedMonth, pickedDay)

                val dateFormat = SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault())
                val formattedDate = dateFormat.format(pickedCalendar.time)
                binding.calendarDayText.text = formattedDate }
               , currentYear, currentMonth, currentDay
        )
        datePickerDialog.show()
    }
}