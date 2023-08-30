package com.netset.fitness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netset.fitness.databinding.FragmentAddAlarmBinding

class AddAlarmFragment : Fragment() {

    private lateinit var binding:FragmentAddAlarmBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddAlarmBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addAlarmToolbar.fragmentsText.text="Add Alarm"

        binding.addAlarmToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

}