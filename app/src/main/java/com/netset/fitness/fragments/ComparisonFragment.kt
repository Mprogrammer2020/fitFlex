package com.netset.fitness.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentComparisonBinding
import com.netset.fitness.utils.CommonFunction
import java.text.DateFormatSymbols
import java.util.Calendar

class ComparisonFragment : Fragment() {

   private lateinit var binding: FragmentComparisonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComparisonBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)


        binding.comparisonToolbar.fragmentsText.text="Comparison"
        binding.comparisonToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.compareButton.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                ResultFragment(),
                R.id.dashboardContainerView,true)
        }

        binding.calendarBackgroundImg.setOnClickListener {
            openCalendar( true)
        }
        binding.calendarMonthlyBackgroundImg.setOnClickListener {
            openCalendar(false)
        }

    }

    private fun openCalendar(isMonthly: Boolean) {
        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)

        val datePicker = DatePickerDialog(
            requireContext(),
            { _, year, month, _ ->
                val monthName = DateFormatSymbols().months[month]
                val formattedText = "$monthName"

                if (isMonthly) {
                    binding.monthNameText.text = formattedText
                } else {
                    binding.selectMonthText.text = formattedText

                }
            },
            currentYear,
            currentMonth,
            1
        )

        datePicker.show()
    }
}
