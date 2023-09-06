package com.netset.fitness.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.netset.fitness.utils.AlphaAndScalePageTransformer
import com.netset.fitness.R
import com.netset.fitness.adapters.CarouselSliderAdapter
import com.netset.fitness.databinding.FragmentCarouselSliderBinding
import com.netset.models.CarouselData


class CarouselSliderFragment : Fragment() {
    private lateinit var binding:FragmentCarouselSliderBinding
    private var cardSliderList: ArrayList<CarouselData> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentCarouselSliderBinding.inflate(layoutInflater,container,false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.confirmButton.setOnClickListener {

            val transaction =requireActivity().supportFragmentManager.beginTransaction().replace(
                R.id.registerContainer,
                SuccessRegistrationFragment()
            )
            transaction.commit()
        }



        cardSliderList.add(CarouselData(R.drawable.first_card,"Improve Shape","I have a low amount of body fat \nand need / want to build more \nmuscle"))
        cardSliderList.add(CarouselData(R.drawable.second_card,"Lean & Tone","I’m “skinny fat”. look thin but have \nno shape. I want to add learn \nmuscle in the right way"))
        cardSliderList.add(CarouselData(R.drawable.third_card_goals,"Lose a Fat", "I have over 20 lbs to lose. I want to \ndrop all this fat and gain muscle \nmass"))
        binding.viewPager.offscreenPageLimit = 3
        binding.viewPager.setPageTransformer(false,AlphaAndScalePageTransformer())
        binding.viewPager.adapter =  CarouselSliderAdapter(requireContext(), cardSliderList)
        binding.springDotsIndicator.attachTo(binding.viewPager)



    }


}