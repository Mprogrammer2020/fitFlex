package com.netset.fitness.fragments

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.FindFoodAdapter
import com.netset.fitness.adapters.MealPlannerAdapter
import com.netset.fitness.databinding.FragmentMealPlannerBinding
import com.netset.fitness.databinding.PopupLayoutBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.FindFoodDataItems
import com.netset.models.MealPlannerDataItems


class MealPlannerFragment : Fragment() {
  private lateinit var binding:FragmentMealPlannerBinding
    private var list:ArrayList<MealPlannerDataItems> = ArrayList()
    private var foodList:ArrayList<FindFoodDataItems> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealPlannerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)


        binding.mealToolbar.fragmentsText.text = "Meal Planner"
        requireActivity().window.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.white)


        binding.mealToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.breakfastIcon.setOnClickListener {
            CommonFunction.openFragment(
                requireActivity().supportFragmentManager,
                BreakfastFragment(), R.id.dashboardContainerView, true
            )
        }

        binding.checkIcon.setOnClickListener {
            CommonFunction.openFragment(
                requireActivity().supportFragmentManager,
                MealScheduleFragment(), R.id.dashboardContainerView, true
            )

        }

        binding.weeklyIcon.setOnClickListener {

            val popupBinding = PopupLayoutBinding.inflate(layoutInflater)
            val popupRootView = popupBinding.root
            val popupWindow = PopupWindow(popupRootView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
            popupWindow.setBackgroundDrawable(ContextCompat.getDrawable(requireContext(), android.R.color.transparent))
            val xOffset = binding.weeklyIcon.width
            val yOffset = 0
            popupWindow.showAsDropDown(binding.weeklyIcon, xOffset, yOffset)

        }

        foodListDataShow()
        mealPlannerDataShow()
    }
    private fun foodListDataShow() {
        foodList.clear()
        foodList.add(FindFoodDataItems(R.drawable.right_corner_bg,R.drawable.burger_icon,"Breakfast","120+ foods",R.drawable.common_button_bg))
        foodList.add(FindFoodDataItems(R.drawable.right_corner_pink_bg,R.drawable.burger_icon,"Lunch","320+ foods",R.drawable.common_pink_bg))

        binding.findSomethingFoodRecyclerView.setHasFixedSize(true)
        binding.findSomethingFoodRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val findFoodAdapter = FindFoodAdapter(requireContext(), foodList)
        binding.findSomethingFoodRecyclerView.adapter = findFoodAdapter
    }

    private fun mealPlannerDataShow() {
        list.clear()
        list.add(MealPlannerDataItems(R.drawable.nigiri_icon,"Salmon Nigiri","Today","7:00am",R.drawable.pink_notification_icon))
        list.add(MealPlannerDataItems(R.drawable.glass_icon,"Lowfat Milk","Today","8:00am",R.drawable.grey_notification_icon))

        binding.mealPlannerRecyclerView.setHasFixedSize(true)
        binding.mealPlannerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MealPlannerAdapter(requireContext(), list)
        binding.mealPlannerRecyclerView.adapter = adapter

    }

}