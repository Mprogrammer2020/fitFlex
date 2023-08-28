package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.MealNutritionLayoutBinding
import com.netset.models.MealNutritionDataItem

class MealNutritionAdapter(private val context: Context, private val mealNutritionItems:ArrayList<MealNutritionDataItem>): RecyclerView.Adapter<MealNutritionAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= MealNutritionLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealNutritionItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.typeIcon.setImageResource(mealNutritionItems[position].foodIcon)
        holder.binding.typesText.text=mealNutritionItems[position].foodType
        holder.binding.caloriesText.text=mealNutritionItems[position].calories


    }

    class ViewHolder(val binding: MealNutritionLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}