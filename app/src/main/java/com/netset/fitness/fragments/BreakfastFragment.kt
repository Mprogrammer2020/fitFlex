package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.CategoryDataAdapter
import com.netset.fitness.adapters.PopularDataAdapter
import com.netset.fitness.adapters.RecommendationDietAdapter
import com.netset.fitness.databinding.FragmentBreakfastBinding
import com.netset.models.CategoryDataItems
import com.netset.models.PopularDataItems
import com.netset.models.RecommendationDataItems


class BreakfastFragment : Fragment() {
  private lateinit var binding:FragmentBreakfastBinding
    private var categoryList:ArrayList<CategoryDataItems> = ArrayList()
    private var recommendationList:ArrayList<RecommendationDataItems> = ArrayList()
    private var popularList:ArrayList<PopularDataItems> = ArrayList()




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentBreakfastBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)

        binding.breakfastToolbar.fragmentsText.text="Breakfast"

        binding.breakfastToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        categoryDataShow()
        recommendationDataShow()
        popularDataShow()

    }

    private fun popularDataShow() {
        popularList.clear()
        popularList.add(PopularDataItems(R.drawable.pankcake_iconss,"BlueBarry Pancake","Medium","20mins","120kCal"))
        popularList.add(PopularDataItems(R.drawable.nigiri_icon,"Salmon Nigiri","Medium","32mins","120kCal"))

        binding.popularRecyclerView.setHasFixedSize(true)
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val popularDataAdapter = PopularDataAdapter(requireContext(), popularList)
        binding.popularRecyclerView.adapter = popularDataAdapter
    }

    private fun recommendationDataShow() {
        recommendationList.clear()
        recommendationList.add(RecommendationDataItems(
            R.drawable.recommendation_background,
            R.drawable.pancake_icon,"Honey Pancake","Easy","32mins","120kCal"))
        recommendationList.add(RecommendationDataItems(
            R.drawable.recommendation_background,
            R.drawable.pancake_icon,"Canai Breakfast","Easy","32mins","120kCal"))


        binding.recommendationDietRecyclerView.setHasFixedSize(true)
        binding.recommendationDietRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val recommendationAdapter = RecommendationDietAdapter(requireContext(), recommendationList)
        binding.recommendationDietRecyclerView.adapter = recommendationAdapter
    }

    private fun categoryDataShow() {
        categoryList.clear()
        categoryList.add(CategoryDataItems(R.drawable.category_blue, R.drawable.salad_icon,"Salad"))
        categoryList.add(CategoryDataItems(R.drawable.category_pink, R.drawable.cake_icon,"Cake"))
        categoryList.add(CategoryDataItems(R.drawable.category_blue, R.drawable.pie_icon,"Pie"))
        categoryList.add(CategoryDataItems(R.drawable.category_pink, R.drawable.orange_icon,"Orange"))
        categoryList.add(CategoryDataItems(R.drawable.category_blue, R.drawable.pie_icon,"Pie"))
        categoryList.add(CategoryDataItems(R.drawable.category_pink, R.drawable.cake_icon,"Cake"))


        binding.categoryRecyclerView.setHasFixedSize(true)
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL,false)
        val findFoodAdapter = CategoryDataAdapter(requireContext(), categoryList)
        binding.categoryRecyclerView.adapter = findFoodAdapter
    }

}