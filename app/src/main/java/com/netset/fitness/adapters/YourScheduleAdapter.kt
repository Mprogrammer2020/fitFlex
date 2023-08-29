package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.databinding.YourScheduleLayoutBinding
import com.netset.models.YourScheduleDataItems

class YourScheduleAdapter(private val context: Context, private val yourScheduleItems:ArrayList<YourScheduleDataItems>): RecyclerView.Adapter<YourScheduleAdapter.ViewHolder>(){

    private var selectedItemPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= YourScheduleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return yourScheduleItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.weeklyText.text=yourScheduleItems[position].week
        holder.binding.dateText.text = yourScheduleItems[position].day


        if (selectedItemPosition == position) {
            holder.binding.calendarBackground.setImageResource(R.drawable.calendar_blu_background)
            holder.binding.weeklyText.setTextColor(ContextCompat.getColor(context, R.color.white))
            holder.binding.dateText.setTextColor(ContextCompat.getColor(context, R.color.white))

        } else {
            holder.binding.calendarBackground.setImageResource(R.drawable.calendar_white_background)
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



    class ViewHolder(val binding: YourScheduleLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
