package com.netset.fitness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.netset.fitness.ProgressPhotoFragment
import com.netset.fitness.fragments.MealPlannerFragment
import com.netset.fitness.R
import com.netset.fitness.databinding.ActivityDashBoardBinding
import com.netset.fitness.fragments.HomeFragment
import com.netset.fitness.fragments.ProfileFragment
import com.netset.fitness.fragments.SleepTrackerFragment
import com.netset.fitness.fragments.WorkoutTrackerFragment
import com.netset.fitness.utils.CommonFunction

class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDashBoardBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        changeFragment(HomeFragment())
        binding.bottomBar.selectedItemId=R.id.homeIcon



        binding.bottomBar.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeIcon -> {
                    changeFragment(HomeFragment())
                    window.statusBarColor=ContextCompat.getColor(this,R.color.white)

                }

                R.id.activityIcon -> {
                    changeFragment(WorkoutTrackerFragment())
                    window.statusBarColor=ContextCompat.getColor(this,R.color.pale_blue)

                }

                R.id.cameraIcon -> {
                changeFragment(ProgressPhotoFragment())
                    window.statusBarColor=ContextCompat.getColor(this,R.color.white)


                }
                R.id.profileIcon -> {
                    changeFragment(ProfileFragment())
                    window.statusBarColor=ContextCompat.getColor(this,R.color.white)

                }
            }
            true
        }


    }
    private fun changeFragment(fragment:Fragment) {
        val transaction = supportFragmentManager.beginTransaction().replace(R.id.dashboardContainerView,fragment)
        transaction.commit()
    }

    fun showHideBottomBar(status:Boolean){
        if (!status){
            binding.bottomBar.visibility = View.GONE
            binding.fab.visibility=View.GONE
            binding.searchIcon.visibility=View.GONE

        }
        else{
            binding.bottomBar.visibility = View.VISIBLE
            binding.fab.visibility=View.VISIBLE
            binding.searchIcon.visibility=View.VISIBLE

        }

    }
}