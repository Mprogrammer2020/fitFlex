package com.netset.fitness.adapters

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.core.text.bold
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.TodayScheduleLayoutBinding
import com.netset.models.TodayScheduleDataItems

class TodayScheduleAdapter(private val context: Context, private val todayScheduleItems:ArrayList<TodayScheduleDataItems>): RecyclerView.Adapter<TodayScheduleAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= TodayScheduleLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return todayScheduleItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.iconType.setImageResource(todayScheduleItems[position].icon)
        holder.binding.bedtimeText.text=todayScheduleItems[position].typeText
        holder.binding.hoursMinutesText.text=todayScheduleItems[position].hoursMinutes


    }

    class ViewHolder(val binding: TodayScheduleLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}