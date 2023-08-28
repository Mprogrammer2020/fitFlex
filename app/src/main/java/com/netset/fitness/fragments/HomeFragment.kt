package com.netset.fitness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.LatestWorkoutAdapter
import com.netset.fitness.databinding.FragmentHomeBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.LatestWorkoutItems


class HomeFragment : Fragment() {
 private lateinit var binding:FragmentHomeBinding
    private var list:ArrayList<LatestWorkoutItems> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(true)

        binding.notificationBackground.setOnClickListener {

            CommonFunction.openFragment(requireActivity().supportFragmentManager, NotificationFragment(),R.id.dashboardContainerView,true)

        }


        binding.checkIcon.setOnClickListener {


            CommonFunction.openFragment(requireActivity().supportFragmentManager, ActivityTrackerFragment(),R.id.dashboardContainerView,true)

        }
        list.add(LatestWorkoutItems("Fullbody Workout","180 Calories Burn","20minutes",R.drawable.running_boy_background))
        list.add(LatestWorkoutItems("Loverbody Workout","200 Calories Burn","30minutes",R.drawable.girl_gym_background))
        list.add(LatestWorkoutItems("Ab Workout","180 Calories Burn","40minutes",R.drawable.gym_boy_background))

        binding.latestWorkoutRecyclerView.setHasFixedSize(true)
        binding.latestWorkoutRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = LatestWorkoutAdapter(requireContext(), list)
        binding.latestWorkoutRecyclerView.adapter = adapter
    }
}