package com.netset.fitness.activities

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.netset.fitness.R
import com.netset.fitness.databinding.ActivityDashBoardBinding
import com.netset.fitness.fragments.ActivityFragment
import com.netset.fitness.fragments.CameraFragment
import com.netset.fitness.fragments.HomeFragment
import com.netset.fitness.fragments.ProfileFragment
import com.netset.fitness.fragments.ProgressPhotoFragment
import com.netset.fitness.fragments.WorkoutTrackerFragment


class DashBoardActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDashBoardBinding

    private val time = 2000
    private var doubleBackPressed = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashBoardBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.bottomBar.setOnItemSelectedListener { item ->


            when (item.itemId) {
                R.id.homeIcon -> {

                    changeFragment(HomeFragment())
                    window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                }

                R.id.activityIcon -> {

                    changeFragment(WorkoutTrackerFragment())
                    window.statusBarColor = ContextCompat.getColor(this, R.color.pale_blue)

                }

                R.id.cameraIcon -> {

                    changeFragment(ProgressPhotoFragment())
                    window.statusBarColor = ContextCompat.getColor(this, R.color.white)
                }

                R.id.profileIcon -> {

                    changeFragment(ProfileFragment())
                    window.statusBarColor = ContextCompat.getColor(this, R.color.white)

                }
            }

            true
        }


        binding.bottomBar.selectedItemId = R.id.homeIcon
    }


    private fun changeFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction().replace(R.id.dashboardContainerView, fragment)
        transaction.commit()
    }

    fun showHideBottomBar(status: Boolean) {
        if (!status) {
            binding.bottomBar.visibility = View.GONE
            binding.fab.visibility = View.GONE

        } else {
            binding.bottomBar.visibility = View.VISIBLE
            binding.fab.visibility = View.VISIBLE

        }

    }


    override fun onBackPressed() {

        val fragmentInstance = supportFragmentManager.findFragmentById(R.id.dashboardContainerView)
        if (fragmentInstance is HomeFragment) {
            if (doubleBackPressed) {
                super.onBackPressedDispatcher.onBackPressed()
            } else {
                Toast.makeText(this, "press again to exit", Toast.LENGTH_SHORT).show()
                doubleBackPressed = true
                Handler().postDelayed({ doubleBackPressed = false }, time.toLong())
            }
        } else if (fragmentInstance is ProfileFragment || fragmentInstance is ProgressPhotoFragment || fragmentInstance is WorkoutTrackerFragment)
            {
                binding.bottomBar.selectedItemId = R.id.homeIcon
                window.statusBarColor = ContextCompat.getColor(this, R.color.white)
            }
            else{
                super.onBackPressedDispatcher.onBackPressed()
            }


    }
}
