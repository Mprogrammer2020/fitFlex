package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netset.fitness.databinding.FragmentStatisticBinding


class StatisticFragment : Fragment() {
   private lateinit var binding:FragmentStatisticBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment

        binding = FragmentStatisticBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
}