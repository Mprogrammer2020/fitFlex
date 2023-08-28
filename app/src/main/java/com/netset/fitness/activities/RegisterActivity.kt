package com.netset.fitness.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netset.fitness.R
import com.netset.fitness.fragments.RegisterFragment
import com.netset.fitness.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction =supportFragmentManager.beginTransaction().replace(R.id.registerContainer,
            RegisterFragment()
        )
        transaction.commit()
    }
}