package com.netset.fitness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netset.fitness.databinding.ActivityWorkoutTrackerBinding

class WorkoutTrackerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWorkoutTrackerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutTrackerBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}