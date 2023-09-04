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

        binding.activityTrackerToolbar.fragmentsText.text="Activity Tracker"

        binding.activityTrackerToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
        LatestActivityDataShow()


        val waterLiterShader: Shader = LinearGradient(
            0f,
            0f,
            binding.waterLiterText.paint.measureText(binding.waterLiterText.text.toString()),
            binding.waterLiterText.textSize,
            intArrayOf(
                ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.waterLiterText.paint.shader = waterLiterShader


        val footShader: Shader = LinearGradient(
            0f,
            0f,
            binding.footText.paint.measureText(binding.footText.text.toString()),
            binding.footText.textSize,
            intArrayOf(
                ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.footText.paint.shader = footShader

    }

    private fun LatestActivityDataShow() {
        list.clear()
        list.add(LatestActivityData(R.drawable.girls_shake_background,"Drinking 300ml Water","About 1 minutes ago"))
        list.add(LatestActivityData(R.drawable.girls_juice_background,"Eat Snack (Fitbar)","About 3 hours ago"))
        binding.latestActivityRecyclerView.setHasFixedSize(true)
        binding.latestActivityRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = LatestActivityTrackerAdapter(requireContext(), list)
        binding.latestActivityRecyclerView.adapter = adapter
    }

}