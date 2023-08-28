package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.databinding.TimelineLayoutBinding
import com.netset.fitness.databinding.TimelineStepsLayoutBinding
import com.netset.models.TimeLineDataItems
import com.netset.models.TimelineStepsDataItems

class TimelineStepsAdapter(private val context: Context, private val timeLineStepsItems:ArrayList<TimelineStepsDataItems>): RecyclerView.Adapter<TimelineStepsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= TimelineStepsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return timeLineStepsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.numberText.text= timeLineStepsItems[position].number
        holder.binding.titleText.text=timeLineStepsItems[position].step
        holder.binding.descriptioinText.text=timeLineStepsItems[position].description

        when (position) {
            0 -> {
                holder.binding.numberText.setTextColor(ContextCompat.getColor(context, R.color.purpleStart))
                holder.binding.radioIcon.setImageResource(R.drawable.radio_icon)
                holder.binding.firstView.setBackgroundResource(R.drawable.vertical_dashed_line)
            }

            timeLineStepsItems.size - 1 -> {
                holder.binding.firstView.visibility = View.GONE
                holder.binding.radioIcon.setImageResource(R.drawable.radio_grey_icon)
                holder.binding.numberText.setTextColor(ContextCompat.getColor(context,R.color.grey))

            }

            else -> {
                holder.binding.firstView.setBackgroundResource(R.drawable.grey_dash_line)
                holder.binding.firstView.visibility = View.VISIBLE
                holder.binding.numberText.setTextColor(ContextCompat.getColor(context,R.color.grey))
                holder.binding.radioIcon.setImageResource(R.drawable.radio_grey_icon)
            }

        }
    }

    class ViewHolder(val binding: TimelineStepsLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}