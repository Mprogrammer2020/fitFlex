package com.netset.fitness.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.netset.fitness.R
import com.netset.fitness.databinding.FragmentSplashBinding
import com.netset.fitness.utils.CommonFunction


class SplashFragment : Fragment() {

   private lateinit var binding: FragmentSplashBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSplashBinding.inflate(layoutInflater,container,false)


        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({

            CommonFunction.openFragment(requireActivity().supportFragmentManager,IntroFragment(),R.id.introScreenContainer,false)

        }, 3000)
    }
}