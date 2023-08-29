package com.netset.fitness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.netset.fitness.ProgressPhotoFragment
import com.netset.fitness.fragments.MealPlannerFragment
import com.netset.fitness.R
import com.netset.fitness.databinding.ActivityDashBoardBinding
import com.netset.fitness.fragments.HomeFragment
import com.netset.fitness.fragments.ProfileFragment
import com.netset.fitness.fragments.SleepTrackerFragment
import com.netset.fitness.fragments.WorkoutTrackerFragment

class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        changeFragment(HomeFragment())


        binding.homeIcon.setOnClickListener {
            changeFragment(HomeFragment())

        }

        binding.activityIcon.setOnClickListener {
            changeFragment(WorkoutTrackerFragment())

        }

        binding.cameraIcon.setOnClickListener {

            binding.cameraIcon.setImageResource(R.drawable.camera_active)
            binding.profileIcon.setImageResource(R.drawable.profile_icon)


            changeFragment(ProgressPhotoFragment())

        }

        binding.profileIcon.setOnClickListener {
            binding.profileIcon.setImageResource(R.drawable.profile_active)
            binding.cameraIcon.setImageResource(R.drawable.camera_icon)

            changeFragment(ProfileFragment())
        }
    }
    private fun changeFragment(fragment:Fragment) {
        val transaction = supportFragmentManager.beginTransaction().replace(R.id.dashboardContainerView,fragment)
        transaction.commit()
    }

    fun showHideBottomBar(status:Boolean){
        if (!status){
            binding.constraintLayout.visibility = View.GONE
            binding.searchIcon.visibility=View.GONE
        }
        else{
            binding.constraintLayout.visibility = View.VISIBLE
            binding.searchIcon.visibility=View.VISIBLE

        }

    }
}