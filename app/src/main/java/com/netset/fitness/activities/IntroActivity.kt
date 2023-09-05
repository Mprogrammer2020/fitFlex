package com.netset.fitness.activities


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netset.fitness.R
import com.netset.fitness.fragments.SplashFragment
import com.netset.fitness.databinding.ActivityIntroBinding
import com.netset.fitness.utils.CommonFunction

class IntroActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntroBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CommonFunction.openFragment(supportFragmentManager,SplashFragment(),R.id.introScreenContainer,false)

    }
}