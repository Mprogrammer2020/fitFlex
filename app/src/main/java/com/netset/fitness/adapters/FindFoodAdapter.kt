package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.FindFoodLayoutBinding
import com.netset.models.FindFoodDataItems

class FindFoodAdapter(private val context: Context, private val findFoodItems:ArrayList<FindFoodDataItems>): RecyclerView.Adapter<FindFoodAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= FindFoodLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return findFoodItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.blueRoundBackground.setBackgroundResource(findFoodItems[position].background)
        holder.binding.foodItemsImg.setImageResource(findFoodItems[position].foodItemImg)
        holder.binding.breakfastText.text=findFoodItems[position].foodNameText
        holder.binding.allFoodTypesText.text = findFoodItems[position].foodTypeText
        holder.binding.selectImg.setBackgroundResource(findFoodItems[position].selectImage)



    }



    class ViewHolder(val binding: FindFoodLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
