package com.netset.fitness.fragments

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.IngredientsAdapter
import com.netset.fitness.adapters.NutritionAdapter
import com.netset.fitness.adapters.TimelineStepsAdapter
import com.netset.fitness.databinding.FragmentMealDetailsBinding
import com.netset.models.IngredientsDataItems
import com.netset.models.NutritionDataItems
import com.netset.models.TimelineStepsDataItems


class MealDetailsFragment : Fragment() {

    private lateinit var binding:FragmentMealDetailsBinding
    private var nutritionList:ArrayList<NutritionDataItems> = ArrayList()
    private var ingredientsList:ArrayList<IngredientsDataItems> = ArrayList()
    private var timeLineStepList:ArrayList<TimelineStepsDataItems> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealDetailsBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as DashBoardActivity?)?.showHideBottomBar(false)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),R.color.pale_blue)



        binding.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        val shader: Shader = LinearGradient(
            0f,
            0f,
            binding.madeByText.paint.measureText(binding.madeByText.text.toString()),
            binding.madeByText.textSize,
            intArrayOf(ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.madeByText.paint.shader = shader


        nutritionDataShow()
        intgredientsDataShow()
        timeLineStepsDataShow()

    }

    private fun timeLineStepsDataShow() {
        timeLineStepList.clear()
        timeLineStepList.add(TimelineStepsDataItems("01","Step 1","Prepare all of the ingredients that needed"))
        timeLineStepList.add(TimelineStepsDataItems("02","Step 2","Mix flour, sugar, salt, and baking powder"))
        timeLineStepList.add(TimelineStepsDataItems("03","Step 3","In a seperate place, mix the eggs and liquid milk until blended"))
        binding.timelineStepsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val timelineStepsAdapter = TimelineStepsAdapter(requireContext(),timeLineStepList)
        binding.timelineStepsRecyclerView.adapter = timelineStepsAdapter
    }

    private fun nutritionDataShow() {

        nutritionList.clear()
        nutritionList.add(NutritionDataItems(
            R.drawable.nutrition_bg,
            R.drawable.calories_icon,"120kCal"))
        nutritionList.add(NutritionDataItems(R.drawable.nutrition_bg, R.drawable.egg_icon,"30g fats"))
        nutritionList.add(NutritionDataItems(R.drawable.nutrition_bg,
            R.drawable.proteins_icon,"20g proteins"))
        nutritionList.add(NutritionDataItems(R.drawable.nutrition_bg, R.drawable.egg_icon,"30g fats"))

        binding.nutritionRecyclerView.setHasFixedSize(true)
        binding.nutritionRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        val findFoodAdapter = NutritionAdapter(requireContext(), nutritionList)
        binding.nutritionRecyclerView.adapter = findFoodAdapter

    }

    private fun intgredientsDataShow() {
        ingredientsList.clear()
        ingredientsList.add(IngredientsDataItems(R.drawable.wheat_flour_icon,"Wheat Flour","12g"))
        ingredientsList.add(IngredientsDataItems(R.drawable.sugarcanw_icon,"Sugar","3 tbsp"))
        ingredientsList.add(IngredientsDataItems(R.drawable.baking_soda_icon,"Baking Soda","2 tsp"))
        ingredientsList.add(IngredientsDataItems(R.drawable.eggs_icon,"Eggs","2 items"))

        binding.interdientsRecyclerView.setHasFixedSize(true)
        binding.interdientsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL,false)
        val ingredientsAdapter = IngredientsAdapter(requireContext(), ingredientsList)
        binding.interdientsRecyclerView.adapter = ingredientsAdapter
    }

}