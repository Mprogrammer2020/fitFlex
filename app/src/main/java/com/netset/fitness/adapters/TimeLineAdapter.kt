package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.TimelineLayoutBinding
import com.netset.models.TimeLineDataItems

class TimeLineAdapter(private val context: Context, private val timeLineItems:ArrayList<TimeLineDataItems>): RecyclerView.Adapter<TimeLineAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= TimelineLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return timeLineItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.numberText.text= timeLineItems[position].number
        holder.binding.titleText.text=timeLineItems[position].title
        holder.binding.descriptioinText.text=timeLineItems[position].description

        if (position == timeLineItems.size - 1) {
            holder.binding.firstView.visibility = View.GONE
        } else {
            holder.binding.firstView.visibility = View.VISIBLE
        }

    }

    class ViewHolder(val binding: TimelineLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}