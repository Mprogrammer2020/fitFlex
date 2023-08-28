package com.netset.fitness.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netset.fitness.R
import com.netset.fitness.fragments.SplashFragment
import com.netset.fitness.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val transaction = supportFragmentManager.beginTransaction().replace(R.id.introScreenContainer,SplashFragment())
        transaction.commit()

    }
}