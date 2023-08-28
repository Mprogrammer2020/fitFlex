package com.netset.fitness.adapters

import android.content.Context
import com.netset.fitness.databinding.LatestWorkoutBinding
import com.netset.models.LatestWorkoutItems
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LatestWorkoutAdapter(private val context: Context,private val workoutItems:ArrayList<LatestWorkoutItems>): RecyclerView.Adapter<LatestWorkoutAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LatestWorkoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workoutItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.workoutNameText.text=workoutItems[position].workOutNames
        holder.binding.caloriesText.text=workoutItems[position].calories
        holder.binding.timesText.text=workoutItems[position].minutes
        holder.binding.backgroundImg.setImageResource(workoutItems[position].workoutImg)


    }

    class ViewHolder(val binding:LatestWorkoutBinding):RecyclerView.ViewHolder(binding.root) {

    }
}