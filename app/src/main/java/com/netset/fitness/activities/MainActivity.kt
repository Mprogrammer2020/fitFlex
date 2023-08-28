package com.netset.fitness.activities

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.netset.fitness.R


class MainActivity : AppCompatActivity() {
    private lateinit var progressBar: ProgressBar
    private lateinit var nextButton: Button
    private var progressValue = 25
    private var increment = 25
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        progressBar = findViewById(R.id.progressBar)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {
            progressValue += increment
            if (progressValue > 100) {
                progressValue = 0

            }
            progressBar.progress = progressValue
        }
    }
    override fun onResume() {
        super.onResume()
        // Reset progress when returning to the main activity
        progressValue = 0
        progressBar.progress = progressValue
    }
}