package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.RecommendationDietLayoutBinding
import com.netset.models.RecommendationDataItems

class RecommendationDietAdapter(private val context: Context, private val recommendationItems:ArrayList<RecommendationDataItems>): RecyclerView.Adapter<RecommendationDietAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= RecommendationDietLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return recommendationItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.foodItemNameIcon.setImageResource(recommendationItems[position].foodIconImg)
        holder.binding.foodItemNameText.text=recommendationItems[position].itemNames
        holder.binding.easyText.text = recommendationItems[position].types
        holder.binding.minutesText.text=recommendationItems[position].minutes
        holder.binding.caloriesBurnText.text=recommendationItems[position].calories



    }



    class ViewHolder(val binding: RecommendationDietLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
