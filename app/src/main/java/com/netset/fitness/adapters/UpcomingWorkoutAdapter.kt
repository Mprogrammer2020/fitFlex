package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.UpcomingWorkoutLayoutBinding
import com.netset.models.UpcomingWorkoutItems

class UpcomingWorkoutAdapter(private val context: Context, private val upcomingWorkoutItems:ArrayList<UpcomingWorkoutItems>): RecyclerView.Adapter<UpcomingWorkoutAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= UpcomingWorkoutLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return upcomingWorkoutItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.checkBox.isChecked = position==0

        holder.binding.backgroundImg.setImageResource(upcomingWorkoutItems[position].workoutImg)
        holder.binding.workoutNamesText.text=upcomingWorkoutItems[position].workoutNames
        holder.binding.timesText.text=upcomingWorkoutItems[position].times



    }

    class ViewHolder(val binding: UpcomingWorkoutLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}