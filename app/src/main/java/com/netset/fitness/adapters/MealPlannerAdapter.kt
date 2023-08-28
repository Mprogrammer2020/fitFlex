package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.MealPlannerLayoutBinding
import com.netset.models.MealPlannerDataItems

class MealPlannerAdapter(private val context: Context, private val mealPlannerItems:ArrayList<MealPlannerDataItems>): RecyclerView.Adapter<MealPlannerAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= MealPlannerLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealPlannerItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.backgroundImg.setImageResource(mealPlannerItems[position].foodItemsImg)
        holder.binding.foodNamesText.text=mealPlannerItems[position].itemName
        holder.binding.todayText.text = mealPlannerItems[position].dayText
        holder.binding.timesText.text=mealPlannerItems[position].times
        holder.binding.notificationIcon.setImageResource(mealPlannerItems[position].notificationIcon)



    }



    class ViewHolder(val binding: MealPlannerLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
