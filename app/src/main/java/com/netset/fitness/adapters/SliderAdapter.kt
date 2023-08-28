package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.netset.fitness.R
import com.netset.models.SliderData

class SliderAdapter(private val context: Context, val sliderList: ArrayList<SliderData>) : PagerAdapter() {

    override fun getCount(): Int {

        return sliderList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object` as RelativeLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view: View = layoutInflater.inflate(R.layout.slider_item, container, false)

        val imageView: ImageView = view.findViewById(R.id.sliderImage)
        val sliderHeadingTV: TextView = view.findViewById(R.id.titleSliderText)
        val sliderDescTV: TextView = view.findViewById(R.id.descriptionSliderText)


        val sliderData: SliderData = sliderList[position]
        sliderHeadingTV.text = sliderData.slideTitle
        sliderDescTV.text = sliderData.slideDescription
        imageView.setImageResource(sliderData.slideImage)

        // on below line we are adding our view to container.
        container.addView(view)

        // on below line we are returning our view.
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as RelativeLayout)
    }

}