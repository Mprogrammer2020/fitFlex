package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.databinding.CustomRepetitionLayoutBinding
import com.netset.models.CustomRepetitionsDataItems

class CustomRepetitionsAdapter(private val context: Context, private val customItems:ArrayList<CustomRepetitionsDataItems>): RecyclerView.Adapter<CustomRepetitionsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= CustomRepetitionLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return customItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (position==customItems.size-1){
            holder.binding.bottomView.visibility = View.GONE
        }

        holder.binding.caloriesBurnIcon.setImageResource(customItems[position].image)
        holder.binding.caloriesText.text=customItems[position].caloriesText
        holder.binding.timesText.text = customItems[position].times.toString()




    }





    class ViewHolder(val binding: CustomRepetitionLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
