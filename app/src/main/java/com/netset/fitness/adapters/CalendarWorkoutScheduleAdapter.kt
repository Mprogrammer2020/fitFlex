package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.databinding.CalendarWorkoutScheduleLayoutBinding
import com.netset.models.CalendarWorkoutScheduleDataItems

class CalendarWorkoutScheduleAdapter(private val context: Context, private val calendarWorkoutScheduleItems:ArrayList<CalendarWorkoutScheduleDataItems>): RecyclerView.Adapter<CalendarWorkoutScheduleAdapter.ViewHolder>(){

    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= CalendarWorkoutScheduleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return calendarWorkoutScheduleItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.weeklyText.text=calendarWorkoutScheduleItems[position].week
        holder.binding.dateText.text = calendarWorkoutScheduleItems[position].day


        if (selectedItemPosition == position) {
            holder.binding.calendarBackground.setBackgroundResource(R.drawable.calendar_gradient_bg)
            holder.binding.weeklyText.setTextColor(ContextCompat.getColor(context, R.color.white))
            holder.binding.dateText.setTextColor(ContextCompat.getColor(context, R.color.white))

        } else {
            holder.binding.calendarBackground.setBackgroundResource(R.drawable.calendar_bg)
            holder.binding.weeklyText.setTextColor(ContextCompat.getColor(context, R.color.grey))
            holder.binding.dateText.setTextColor(ContextCompat.getColor(context, R.color.grey))


        }

        holder.binding.calendarBackground.setOnClickListener {
            // Update the selected item position
            selectedItemPosition = holder.adapterPosition
            // Notify the adapter that the data has changed
            notifyDataSetChanged()
        }

    }



    class ViewHolder(val binding: CalendarWorkoutScheduleLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
