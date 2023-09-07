package com.netset.fitness

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.ExerciseSetsAdapter
import com.netset.fitness.adapters.GymItemsAdapter
import com.netset.fitness.adapters.IngredientsAdapter
import com.netset.fitness.adapters.NutritionAdapter
import com.netset.fitness.adapters.TimelineStepsAdapter
import com.netset.fitness.databinding.FragmentDemoBinding
import com.netset.models.ExerciseSetItems
import com.netset.models.GymItems
import com.netset.models.IngredientsDataItems
import com.netset.models.NutritionDataItems
import com.netset.models.TimelineStepsDataItems


class DemoFragment : Fragment() {
    private lateinit var binding:FragmentDemoBinding
    private var list:ArrayList<GymItems> = ArrayList()
    private var exerciseSetsItems:ArrayList<ExerciseSetItems> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDemoBinding.inflate(layoutInflater,container,false)

//        binding.demoTool.toolBackground.background= ColorDrawable(ContextCompat.getColor(requireActivity(),android.R.color.transparent))
//        binding.demoTool.fragmentsText.text=""
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)

        gymItemsDataShow()
        exerciseSetsItemsDataShow()

    }

    private fun exerciseSetsItemsDataShow() {
        exerciseSetsItems.add(ExerciseSetItems("Set 1", arrayListOf<ExerciseSetItems.NestedExerciseSetsItems>(
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.exercises_sets,"Warm Up","05:00"),
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.jumping_icon,"Jumping Jack","12x"),
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.skipping_icon,"Skipping","15x"),
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.exerxise_down_icon,"Squats","20x"))))


        exerciseSetsItems.add(ExerciseSetItems("Set 2", arrayListOf<ExerciseSetItems.NestedExerciseSetsItems>(
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.down_icon,"Incline Push-Ups","12x"),
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.pushup_icon,"Push-Ups","12x"))))

        exerciseSetsItems.add(ExerciseSetItems("Set 3", arrayListOf<ExerciseSetItems.NestedExerciseSetsItems>(
            ExerciseSetItems.NestedExerciseSetsItems(R.drawable.exercises_sets,"Cobra Stretch","15x"))))


        binding.exerciseSetsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val exerciseSetsAdapter = ExerciseSetsAdapter(requireContext(), exerciseSetsItems)
        binding.exerciseSetsRecyclerView.adapter = exerciseSetsAdapter
    }

    private fun gymItemsDataShow() {
        list.clear()
        list.add(GymItems(R.drawable.barbel,"Barbell"))
        list.add(GymItems(R.drawable.skipping_rope,"Skipping Rope"))
        list.add(GymItems(R.drawable.barbel,"Barbell"))
        list.add(GymItems(R.drawable.skipping_rope,"Skipping Rope"))
        binding.gymItemsRecyclerView.setHasFixedSize(true)
        binding.gymItemsRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val trainingAdapter = GymItemsAdapter(requireContext(), list)
        binding.gymItemsRecyclerView.adapter = trainingAdapter
    }


}