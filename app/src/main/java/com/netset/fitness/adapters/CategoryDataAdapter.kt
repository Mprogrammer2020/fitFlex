package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.CategoryLayoutBinding
import com.netset.fitness.databinding.FindFoodLayoutBinding
import com.netset.models.CategoryDataItems
import com.netset.models.FindFoodDataItems

class CategoryDataAdapter(private val context: Context, private val categoryItems:ArrayList<CategoryDataItems>): RecyclerView.Adapter<CategoryDataAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= CategoryLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.blueBackgroundIcon.setBackgroundResource(categoryItems[position].imgBackground)
        holder.binding.foodIcon.setImageResource(categoryItems[position].foodIcon)
        holder.binding.foodTypeNameText.text = categoryItems[position].foodName



    }



    class ViewHolder(val binding: CategoryLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
