package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.databinding.CalendarLayoutBinding
import com.netset.fitness.databinding.FindFoodLayoutBinding
import com.netset.models.CalendarDataItems
import com.netset.models.FindFoodDataItems

class CalendarAdapter(private val context: Context, private val calendarItems:ArrayList<CalendarDataItems>): RecyclerView.Adapter<CalendarAdapter.ViewHolder>(){

    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= CalendarLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return calendarItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.weeklyText.text=calendarItems[position].week
        holder.binding.dateText.text = calendarItems[position].day


        if (selectedItemPosition == position) {
            holder.binding.calendarBackground.setImageResource(R.drawable.calendar_blu_background)
            holder.binding.weeklyText.setTextColor(ContextCompat.getColor(context,R.color.white))
            holder.binding.dateText.setTextColor(ContextCompat.getColor(context,R.color.white))

        } else {
            holder.binding.calendarBackground.setImageResource(R.drawable.calendar_white_background)
            holder.binding.weeklyText.setTextColor(ContextCompat.getColor(context,R.color.grey))
            holder.binding.dateText.setTextColor(ContextCompat.getColor(context,R.color.grey))


        }

        holder.binding.calendarBackground.setOnClickListener {
            // Update the selected item position
            selectedItemPosition = holder.adapterPosition
            // Notify the adapter that the data has changed
            notifyDataSetChanged()
        }

    }



    class ViewHolder(val binding: CalendarLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
