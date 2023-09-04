package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentResultBinding
import com.netset.fitness.utils.CommonFunction


class ResultFragment : Fragment() {
   private lateinit var binding: FragmentResultBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentResultBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)


        binding.resultToolbar.fragmentsText.text="Result"
        binding.resultToolbar.shareIconBackground.visibility=View.VISIBLE
        binding.resultToolbar.shareIcon.visibility=View.VISIBLE

        binding.resultToolbar.backIconBackground.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        CommonFunction.openFragment(requireActivity().supportFragmentManager,
            PhotoFragment(), R.id.comparisonResultContainer,false)


        binding.statisticText.setOnClickListener {
            binding.statisticIcon.visibility=View.VISIBLE
            binding.statisticText.visibility=View.GONE
            binding.photoIcon.visibility=View.INVISIBLE
            binding.photoText.visibility=View.VISIBLE
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                StatisticFragment(),
                R.id.comparisonResultContainer,false)

        }

        binding.photoText.setOnClickListener {
            binding.statisticIcon.visibility=View.INVISIBLE
            binding.statisticText.visibility=View.VISIBLE
            binding.photoIcon.visibility=View.VISIBLE
            binding.photoText.visibility=View.VISIBLE
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                PhotoFragment(), R.id.comparisonResultContainer,false)

        }
    }

}