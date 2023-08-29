package com.netset.fitness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netset.fitness.databinding.FragmentComparisonBinding
import com.netset.fitness.databinding.NestedGalleryLayoutBinding
import com.netset.fitness.utils.CommonFunction

class ComparisonFragment : Fragment() {

   private lateinit var binding: FragmentComparisonBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentComparisonBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.comparisonToolbar.fragmentsText.text="Comparison"

        binding.compareButton.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,ResultFragment(),R.id.dashboardContainerView,true)
        }

    }

}