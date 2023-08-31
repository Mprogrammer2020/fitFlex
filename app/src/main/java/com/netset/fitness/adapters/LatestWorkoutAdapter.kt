package com.netset.fitness.adapters

import android.content.Context
import com.netset.fitness.databinding.LatestWorkoutBinding
import com.netset.models.LatestWorkoutItems
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LatestWorkoutAdapter(private val context: Context,private val workoutItems:ArrayList<LatestWorkoutItems>): RecyclerView.Adapter<LatestWorkoutAdapter.ViewHolder>(){

    private var maxAlpha = 1.0f // Max alpha value
    private var minAlpha = 0.5f // Min alpha value
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


        val calculatedAlpha = calculateAlpha(position)
        holder.binding.root.alpha = calculatedAlpha

    }

    private fun calculateAlpha(position: Int): Float {
        val centerPosition = workoutItems.size / 2 // Center position
        val offset = kotlin.math.abs(centerPosition - position).toFloat() // Offset from center
        val maxOffset = centerPosition.toFloat() // Maximum offset
        val alphaRange = maxAlpha - minAlpha
        val adjustedAlpha = maxAlpha - alphaRange * (offset / maxOffset)

        return if (position == centerPosition) {
            maxAlpha
        } else {
            adjustedAlpha.coerceIn(minAlpha, maxAlpha)
        }
    }

    class ViewHolder(val binding:LatestWorkoutBinding):RecyclerView.ViewHolder(binding.root) {

    }
}