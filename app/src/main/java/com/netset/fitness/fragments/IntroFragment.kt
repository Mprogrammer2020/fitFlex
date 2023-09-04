package com.netset.fitness.fragments

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.netset.fitness.R
import com.netset.fitness.databinding.FragmentIntroBinding
import com.netset.fitness.utils.CommonFunction


class IntroFragment : Fragment() {

    private lateinit var binding: FragmentIntroBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View {
        binding = FragmentIntroBinding.inflate(layoutInflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val textShader = LinearGradient(0f, 0f, 0f, binding.getStatedButton.textSize,
            ContextCompat.getColor(requireContext(), R.color.pale_blue),
            ContextCompat.getColor(requireContext(), R.color.light_blue), Shader.TileMode.CLAMP)
          binding.getStatedButton.paint.shader = textShader


        binding.getStatedButton.setOnClickListener {

            CommonFunction.openFragment(requireActivity().supportFragmentManager,IntroSliderFragment(),R.id.introScreenContainer,true)
        }



//        val text = SpannableString("Get started")
//        text.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.pale_blue)), 0, 7, 0)
//        text.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.light_blue)), 8, text.length, 0)
//        binding.getStatedButton.setText(text, BufferType.SPANNABLE)



    }

    }
