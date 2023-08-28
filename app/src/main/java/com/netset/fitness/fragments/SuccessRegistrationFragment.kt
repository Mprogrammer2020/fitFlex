package com.netset.fitness.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentSuccessRegistrationBinding


class SuccessRegistrationFragment : Fragment() {
  private lateinit var binding:FragmentSuccessRegistrationBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSuccessRegistrationBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToHomeButton.setOnClickListener {
            val i = Intent(requireContext(), DashBoardActivity::class.java)
            startActivity(i)
            activity?.finish()
        }
    }
}