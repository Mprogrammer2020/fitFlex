package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.WorkoutTimeScheduleLayoutBinding
import com.netset.models.WorkoutTimeScheduleDataItems

class WorkoutTimeScheduleAdapter(private val context: Context, private val workoutTimeItems:ArrayList<WorkoutTimeScheduleDataItems>): RecyclerView.Adapter<WorkoutTimeScheduleAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= WorkoutTimeScheduleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workoutTimeItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.timeText.text= workoutTimeItems[position].time

        if (position==workoutTimeItems.size-1)
        {
            holder.binding.view.visibility= View.GONE
        } else
        {
            holder.binding.view.visibility= View.VISIBLE

        }

    }

    class ViewHolder(val binding: WorkoutTimeScheduleLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}