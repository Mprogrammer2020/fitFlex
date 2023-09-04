package com.netset.fitness.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.viewpager.widget.ViewPager
import com.netset.fitness.adapters.SliderAdapter
import com.netset.fitness.R
import com.netset.fitness.activities.RegisterActivity
import com.netset.fitness.databinding.FragmentIntroSliderBinding
import com.netset.models.SliderData


class IntroSliderFragment : Fragment() {
   private lateinit var binding:FragmentIntroSliderBinding
   private lateinit var sliderAdapter: SliderAdapter
   private var sliderList: ArrayList<SliderData> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
         binding = FragmentIntroSliderBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.circleBackgroundImage.setOnClickListener {
            val current: Int = getItem(+1)
            if (current<sliderList.size){
                binding.viewPager.currentItem = current

                val totalSlides = sliderList.size
                val progress = ((current + 1) * 100) / totalSlides
                binding.progressBar.progress = progress
            }else {
                val i = Intent(requireContext(), RegisterActivity::class.java)
                startActivity(i)
                activity?.finish()
            }
        }

        sliderList.add(SliderData("Track Your Goal", "Don't worry if you have trouble determining your goals, We can help you determine your goals and track your goals",
            R.drawable.slider_first
        ))
        sliderList.add(SliderData("Get Burn", "Let’s keep burning, to achive yours goals, it hurts only temporarily, if you give up now you will be in pain forever",
            R.drawable.slider_second
        ))
        sliderList.add(SliderData("Eat Well", "Let's start a healthy lifestyle with us, we can determine your diet every day. healthy eating is fun",
            R.drawable.slider_third
        ))
        sliderList.add(SliderData("Improve Sleep \nQuality", "Improve the quality of your sleep with us, good quality sleep can bring a good mood in the morning",
            R.drawable.slider_fourth
        ))

        sliderAdapter = SliderAdapter(requireContext(), sliderList)

        binding.viewPager.adapter = sliderAdapter


        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                // Calculate the progress based on the position
                val totalSlides = sliderList.size
                val progress = ((position + 1) * 100) / totalSlides
                binding.progressBar.progress = progress
            }

            override fun onPageSelected(position: Int) {

            }
        })



    }


    private fun getItem(i: Int): Int {
        return binding.viewPager.currentItem + i

    }
}
