package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.SleepScheduleLayoutBinding
import com.netset.models.SleepScheduleDataItems

class SleepScheduleAdapter(private val context: Context, private val sleepScheduleItems:ArrayList<SleepScheduleDataItems>): RecyclerView.Adapter<SleepScheduleAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= SleepScheduleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return sleepScheduleItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.iconType.setImageResource(sleepScheduleItems[position].icon)
        holder.binding.bedtimeText.text=sleepScheduleItems[position].typeText
        holder.binding.timeText.text=sleepScheduleItems[position].time
        holder.binding.hoursMinutesText.text=sleepScheduleItems[position].hoursMinutes



    }

    class ViewHolder(val binding: SleepScheduleLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}