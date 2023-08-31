package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.CalendarAdapter
import com.netset.fitness.adapters.FoodTypeAdapter
import com.netset.fitness.adapters.MealNutritionAdapter
import com.netset.fitness.databinding.FragmentMealScheduleBinding
import com.netset.models.CalendarDataItems
import com.netset.models.FoodTypeDataItems
import com.netset.models.MealNutritionDataItem
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class MealScheduleFragment : Fragment() {
    private lateinit var binding:FragmentMealScheduleBinding
    private var calendarList:ArrayList<CalendarDataItems> = ArrayList()
    private var foodTypeList:ArrayList<FoodTypeDataItems> = ArrayList()
    private var mealNutritionList:ArrayList<MealNutritionDataItem> = ArrayList()



    private val calendar: Calendar = Calendar.getInstance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealScheduleBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)

        binding.mealscheduleToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }


        binding.mealscheduleToolbar.fragmentsText.text="Meal Schedule"
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

        binding.calendarRecyclerView.setHasFixedSize(true)
        binding.calendarRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val adapter = CalendarAdapter(requireContext(), calendarList)
        binding.calendarRecyclerView.adapter = adapter

        foodTypeDataShow()
        mealNutritionDataShow()

    }

    private fun mealNutritionDataShow() {
        mealNutritionList.clear()
        mealNutritionList.add(MealNutritionDataItem("Calories", R.drawable.calories_icon,"320 kCal"))
        mealNutritionList.add(MealNutritionDataItem("Proteins", R.drawable.proteins_icon,"320g"))
        mealNutritionList.add(MealNutritionDataItem("Fat", R.drawable.egg_icon,"320 kCal"))

        binding.mealNutritionRecyclerView.setHasFixedSize(true)
        binding.mealNutritionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MealNutritionAdapter(requireContext(), mealNutritionList)
        binding.mealNutritionRecyclerView.adapter = adapter

    }

    private fun foodTypeDataShow() {
        foodTypeList.clear()
        foodTypeList.add(FoodTypeDataItems("Breakfast","2 meals","230 calories", arrayListOf(
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.homey_pan_icons,"Honey pancake","07:00am"),
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.coffee_icons,"Coffee","07:30am"), )))

        foodTypeList.add(FoodTypeDataItems("Launch","2 meals","500 calories", arrayListOf(
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.chicken_steak,"Chicken Steak","01:00pm"),
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.milk_background_icon,"Milk","02:00pm"), )))

        foodTypeList.add(FoodTypeDataItems("Snacks","2 meals","140 calories", arrayListOf(
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.orange_icon_bg,"Orange","04:30pm"),
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.apple_pie_bg,"Apple Pie","04:40pm"), )))

        foodTypeList.add(FoodTypeDataItems("Dinner","2 meals","120 calories", arrayListOf(
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.salad_icon_bg,"Salad","07:00pm"),
            FoodTypeDataItems.NestedFoodTypeDataItems(R.drawable.oatmeal_icon_bg,"Oatmeal","08:00pm"), )))

        binding.foodTypeRecyclerView.setHasFixedSize(true)
        binding.foodTypeRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val foodTypeAdapter = FoodTypeAdapter(requireContext(), foodTypeList)
        binding.foodTypeRecyclerView.adapter = foodTypeAdapter
    }

    private fun updateCalendarData() {
        calendarList.clear()
        val daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        val sdf = SimpleDateFormat("E", Locale.getDefault())

        for (dayOfMonth in 1..daysInMonth) {
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            val dayOfWeek = sdf.format(calendar.time)
            calendarList.add(CalendarDataItems(dayOfWeek, dayOfMonth.toString()))
        }

        // Notify the adapter about the changes in data
        binding.calendarRecyclerView.adapter?.notifyDataSetChanged()
    }








   private fun updateMonthYearText() {
    val sdf = SimpleDateFormat("MMMM yyyy", Locale.getDefault())
    val formattedDate = sdf.format(calendar.time)
    binding.monthYearText.text = formattedDate


}

}