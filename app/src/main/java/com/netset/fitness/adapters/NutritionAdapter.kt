package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.NutritionLayoutBinding
import com.netset.fitness.databinding.PopularItemsLayoutBinding
import com.netset.models.NutritionDataItems
import com.netset.models.PopularDataItems

class NutritionAdapter(private val context: Context, private val nutritionsDataItems:ArrayList<NutritionDataItems>): RecyclerView.Adapter<NutritionAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= NutritionLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nutritionsDataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.nutritionImg.setImageResource(nutritionsDataItems[position].background)

        holder.binding.nutritionIcon.setImageResource(nutritionsDataItems[position].nutritionIcon)
        holder.binding.caloriesGramText.text=nutritionsDataItems[position].caloriesGram




    }



    class ViewHolder(val binding: NutritionLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
