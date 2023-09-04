package com.netset.fitness.fragments

import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

   private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding =  FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(true)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),R.color.white)


        binding.profileToolbar.fragmentsText.text="Profile"

        val cmShader: Shader = LinearGradient(
            0f,
            0f,
            binding.cmText.paint.measureText(binding.cmText.text.toString()),
            binding.cmText.textSize,
            intArrayOf(ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.cmText.paint.shader = cmShader


        val kgShader: Shader = LinearGradient(
            0f,
            0f,
            binding.kgText.paint.measureText(binding.kgText.text.toString()),
            binding.kgText.textSize,
            intArrayOf(ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.kgText.paint.shader = kgShader


        val yearShader: Shader = LinearGradient(
            0f,
            0f,
            binding.yearText.paint.measureText(binding.yearText.text.toString()),
            binding.yearText.textSize,
            intArrayOf(ContextCompat.getColor(requireContext(),R.color.pale_blue),
                ContextCompat.getColor(requireContext(),R.color.light_blue)),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        binding.yearText.paint.shader = yearShader

    }
}