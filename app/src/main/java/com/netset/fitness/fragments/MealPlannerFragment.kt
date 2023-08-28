package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.FindFoodAdapter
import com.netset.fitness.adapters.MealPlannerAdapter
import com.netset.fitness.databinding.FragmentMealPlannerBinding
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


        binding.mealToolbar.fragmentsText.text="Meal Planner"

        binding.mealToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        binding.breakfastIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                BreakfastFragment(),R.id.dashboardContainerView,true)
        }

        binding.checkIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                MealScheduleFragment(),R.id.dashboardContainerView,true)

        }

        list.add(MealPlannerDataItems(R.drawable.nigiri_icon,"Salmon Nigiri","Today","7:00am",R.drawable.pink_notification_icon))
        list.add(MealPlannerDataItems(R.drawable.glass_icon,"Lowfat Milk","Today","8:00am",R.drawable.grey_notification_icon))



        binding.mealPlannerRecyclerView.setHasFixedSize(true)
        binding.mealPlannerRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MealPlannerAdapter(requireContext(), list)
        binding.mealPlannerRecyclerView.adapter = adapter

        foodList.add(FindFoodDataItems(R.drawable.burger_icon,"Breakfast","120+ foods",R.drawable.blue_select_icon))
        foodList.add(FindFoodDataItems(R.drawable.burger_icon,"Launch","320+ foods",R.drawable.pink_select_icon))

        binding.findSomethingFoodRecyclerView.setHasFixedSize(true)
        binding.findSomethingFoodRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val findFoodAdapter = FindFoodAdapter(requireContext(), foodList)
        binding.findSomethingFoodRecyclerView.adapter = findFoodAdapter


    }

}