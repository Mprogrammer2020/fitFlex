package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.netset.fitness.R
import com.netset.models.CarouselData
import com.netset.models.SliderData

class CarouselSliderAdapter(private val context: Context, private val cardSliderList: ArrayList<CarouselData>) : PagerAdapter() {


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = layoutInflater.inflate(R.layout.carusoel_items, container, false)
        val card: ImageView = view.findViewById(R.id.cardUserImage)
        val viewCard: ImageView = view.findViewById(R.id.viewImg)

        val titleText: TextView = view.findViewById(R.id.cardTitleText)
        val descriptionText: TextView = view.findViewById(R.id.cardDescriptionText)

        card.setImageResource(cardSliderList[position].cardGoals)
        viewCard.setImageResource(cardSliderList[position].viewImg)
        titleText.text=cardSliderList[position].cardTitle
        descriptionText.text=cardSliderList[position].cardDescription
        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return cardSliderList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}