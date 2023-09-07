package com.netset.fitness.fragments

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.DemoFragment
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

        binding.caloriesLinearLayout.setOnClickListener{
            CommonFunction.openFragment(requireActivity().supportFragmentManager,DemoFragment(),R.id.dashboardContainerView,true)
        }


        bpmTextGradient()
        literTextGradient()
        hoursMinutesFradient()
        caloriesTextGradient()





        binding.notificationBackground.setOnClickListener {

            CommonFunction.openFragment(requireActivity().supportFragmentManager, NotificationFragment(),R.id.dashboardContainerView,true)

        }

        binding.waterIntakeCardView.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager, MealPlannerFragment(),R.id.dashboardContainerView,true)

        }

        binding.sleepCardView.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager, SleepTrackerFragment(),R.id.dashboardContainerView,true)

        }


        binding.checkIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager, ActivityTrackerFragment(),R.id.dashboardContainerView,true)
        }
        list.clear()
        list.add(LatestWorkoutItems("Fullbody Workout","180 Calories Burn","20minutes",R.drawable.running_boy_background))
        list.add(LatestWorkoutItems("Loverbody Workout","200 Calories Burn","30minutes",R.drawable.girl_gym_background))
        list.add(LatestWorkoutItems("Ab Workout","180 Calories Burn","40minutes",R.drawable.gym_boy_background))

        binding.latestWorkoutRecyclerView.setHasFixedSize(true)
        binding.latestWorkoutRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = LatestWorkoutAdapter(requireContext(), list)
        binding.latestWorkoutRecyclerView.adapter = adapter
    }

    private fun caloriesTextGradient() {
        val shader: Shader = LinearGradient(
            0f,
            0f,
            binding.caloreisBurnText.paint.measureText(binding.caloreisBurnText.text.toString()),
            binding.caloreisBurnText.textSize,
            intArrayOf(
                ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.caloreisBurnText.paint.shader = shader    }

    private fun hoursMinutesFradient() {
        val shader: Shader = LinearGradient(
            0f,
            0f,
            binding.hoursMinutesText.paint.measureText(binding.hoursMinutesText.text.toString()),
            binding.hoursMinutesText.textSize,
            intArrayOf(
                ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.hoursMinutesText.paint.shader = shader
    }

    private fun literTextGradient() {
        val shader: Shader = LinearGradient(
            0f,
            0f,
            binding.waterInLiterText.paint.measureText(binding.waterInLiterText.text.toString()),
            binding.waterInLiterText.textSize,
            intArrayOf(
                ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.waterInLiterText.paint.shader = shader

    }

    private fun bpmTextGradient() {
        val bpmShader: Shader = LinearGradient(
            0f,
            0f,
            binding.bpmText.paint.measureText(binding.bpmText.text.toString()),
            binding.bpmText.textSize,
            intArrayOf(
                ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.bpmText.paint.shader = bpmShader

    }
}