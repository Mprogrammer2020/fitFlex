package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.LatestActivityTrackerAdapter
import com.netset.fitness.adapters.UpcomingWorkoutAdapter
import com.netset.fitness.adapters.WorkoutTrainingAdapter
import com.netset.fitness.databinding.FragmentWorkoutTrackerBinding
import com.netset.models.LatestActivityData
import com.netset.models.UpcomingWorkoutItems
import com.netset.models.WorkoutTrainingItems


class WorkoutTrackerFragment : Fragment() {

   private lateinit var binding:FragmentWorkoutTrackerBinding
    private var list:ArrayList<UpcomingWorkoutItems> = ArrayList()
    private var workoutTrainingList:ArrayList<WorkoutTrainingItems> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWorkoutTrackerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(true)


        upcomingWorkoutRecyclerViewDataShow()
        workoutTrainingRecyclerViewDataShow()



    }

    private fun workoutTrainingRecyclerViewDataShow() {
        workoutTrainingList.clear()
        workoutTrainingList.add(WorkoutTrainingItems("Fullbody Workout","11 Exercise","32mins",R.drawable.rope_jump))
        workoutTrainingList.add(WorkoutTrainingItems("Loverbody Workout","12 Exercise","30mins",R.drawable.lowebody_workout))
        workoutTrainingList.add(WorkoutTrainingItems("Fullbody Workout","15 Exercise","39mins",R.drawable.ab_workout))
        binding.workoutTrainingRecyclerView.setHasFixedSize(true)
        binding.workoutTrainingRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val trainingAdapter = WorkoutTrainingAdapter(requireContext(), workoutTrainingList)
        binding.workoutTrainingRecyclerView.adapter = trainingAdapter

    }

    private fun upcomingWorkoutRecyclerViewDataShow() {
        list.clear()
        list.add(UpcomingWorkoutItems(R.drawable.running_boy_background,"Fullbody Workout","Today, 03:00pm"))
        list.add(UpcomingWorkoutItems(R.drawable.workout_pic,"Upperbody Workout","June 05, 02:00pm"))
        binding.upcomingWorkoutRecyclerView.setHasFixedSize(true)
        binding.upcomingWorkoutRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = UpcomingWorkoutAdapter(requireContext(), list)
        binding.upcomingWorkoutRecyclerView.adapter = adapter
    }


}