package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.LatestActivityTrackerAdapter
import com.netset.fitness.databinding.FragmentActivityTrackerBinding
import com.netset.models.LatestActivityData


class ActivityTrackerFragment : Fragment() {
 private lateinit var binding:FragmentActivityTrackerBinding
    private var list:ArrayList<LatestActivityData> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentActivityTrackerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)

        binding.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        list.add(LatestActivityData(R.drawable.girls_shake_background,"Drinking 300ml Water","About 1 minutes ago"))
        list.add(LatestActivityData(R.drawable.girls_juice_background,"Eat Snack (Fitbar)","About 3 hours ago"))




        binding.latestActivityRecyclerView.setHasFixedSize(true)
        binding.latestActivityRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = LatestActivityTrackerAdapter(requireContext(), list)
        binding.latestActivityRecyclerView.adapter = adapter
    }

}