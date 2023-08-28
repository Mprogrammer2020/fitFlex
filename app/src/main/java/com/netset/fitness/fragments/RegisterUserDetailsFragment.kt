package com.netset.fitness.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.core.content.ContextCompat
import com.netset.fitness.R
import com.netset.fitness.databinding.FragmentRegisterUserDetailsBinding
import com.netset.fitness.utils.CommonFunction
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class RegisterUserDetailsFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private lateinit var binding:FragmentRegisterUserDetailsBinding
    private var genderData=""
    private var userDate=""
    private val calendar: Calendar = Calendar.getInstance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegisterUserDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.nextButton.setOnClickListener {

            CommonFunction.openFragment(requireActivity().supportFragmentManager,CarouselSliderFragment(),R.id.registerContainer,true)
        }

        binding.calendarLayout.setOnClickListener {
            openCalendar()
        }

        val adapter = ArrayAdapter.createFromResource(requireContext(),
            R.array.spinner_gender_items,
            R.layout.spinner_gender_layout
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerView.adapter = adapter
        binding.spinnerView.onItemSelectedListener = this
    }

    private fun openCalendar() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                val selectedDate = formatDate(selectedYear, selectedMonth, selectedDay)
                userDate=selectedDate
                binding.dateBirthText.text = selectedDate
              //  binding.dateBirthText.setTextColor(Color.BLACK)
            },
            year, month, day)
        datePickerDialog.show()
        val negativeButton = datePickerDialog.getButton(DatePickerDialog.BUTTON_NEGATIVE)
        negativeButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.pale_blue))
        val positiveButton=datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE)
        positiveButton.setTextColor(ContextCompat.getColor(requireContext(), R.color.pale_blue))

    }

    private fun formatDate(year: Int, month: Int, day: Int): String {
        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)
        val dateFormat = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        return dateFormat.format(calendar.time)
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val text: String = parent?.getItemAtPosition(position).toString()
        genderData=text
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

}