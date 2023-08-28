package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.NestedExerciseSetsLayoutBinding
import com.netset.fitness.databinding.NestedFoodTypeLayoutBinding
import com.netset.models.ExerciseSetItems
import com.netset.models.FoodTypeDataItems

class NestedFoodTypeAdapter(private val context: Context, private val nestedFoodTypeItems:ArrayList<FoodTypeDataItems.NestedFoodTypeDataItems>): RecyclerView.Adapter<NestedFoodTypeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= NestedFoodTypeLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nestedFoodTypeItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.foodIcon.setImageResource(nestedFoodTypeItems[position].foodIcon)
        holder.binding.foodItemNameText.text=nestedFoodTypeItems[position].foodNames
        holder.binding.timesText.text=nestedFoodTypeItems[position].times

    }

    class ViewHolder(val binding: NestedFoodTypeLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}