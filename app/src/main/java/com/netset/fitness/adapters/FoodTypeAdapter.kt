package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.FoodTypeLayoutBinding
import com.netset.models.FoodTypeDataItems

class FoodTypeAdapter(private val context: Context, private val foodTypeDataItems:ArrayList<FoodTypeDataItems>): RecyclerView.Adapter<FoodTypeAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= FoodTypeLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return foodTypeDataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.breakfastText.text = foodTypeDataItems[position].foodType
        holder.binding.mealsText.text = foodTypeDataItems[position].meal
        holder.binding.caloriesText.text = foodTypeDataItems[position].calories


        val childList=foodTypeDataItems[position].nestedFoodTypeList
        val nestedAdapter = NestedFoodTypeAdapter(context,childList)
        holder.binding.nestedFoodTypeRecyclerView.adapter = nestedAdapter

    }



    class ViewHolder(val binding: FoodTypeLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
