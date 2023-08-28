package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.IngredientsLayoutBinding
import com.netset.models.IngredientsDataItems

class IngredientsAdapter(private val context: Context, private val ingredientsDataItems:ArrayList<IngredientsDataItems>): RecyclerView.Adapter<IngredientsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= IngredientsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return ingredientsDataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.itemsIcon.setImageResource(ingredientsDataItems[position].itemImg)
        holder.binding.itemsNameText.text=ingredientsDataItems[position].itemName
        holder.binding.gramText.text=ingredientsDataItems[position].gram





    }



    class ViewHolder(val binding: IngredientsLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
