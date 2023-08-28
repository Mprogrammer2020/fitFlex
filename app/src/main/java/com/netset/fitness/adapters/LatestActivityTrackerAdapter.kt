package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.LatestActivityLayoutBinding
import com.netset.fitness.databinding.LatestWorkoutBinding
import com.netset.models.LatestActivityData
import com.netset.models.LatestWorkoutItems

class LatestActivityTrackerAdapter(private val context: Context, private val latestActivityItems:ArrayList<LatestActivityData>): RecyclerView.Adapter<LatestActivityTrackerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LatestActivityLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return latestActivityItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.backgroundImg.setImageResource(latestActivityItems[position].latestActivityImage)

        holder.binding.drinkingWaterText.text=latestActivityItems[position].drinkingWater
        holder.binding.timesText.text=latestActivityItems[position].time


    }

    class ViewHolder(val binding: LatestActivityLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}