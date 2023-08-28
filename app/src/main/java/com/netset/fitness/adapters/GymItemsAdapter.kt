package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.GymItemsLayoutBinding
import com.netset.models.GymItems

class GymItemsAdapter(private val context: Context, private val gymItems:ArrayList<GymItems>): RecyclerView.Adapter<GymItemsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= GymItemsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gymItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.gymItemsIcon.setImageResource(gymItems[position].gymItems)
        holder.binding.itemsNameText.text=gymItems[position].itemNames


    }

    class ViewHolder(val binding: GymItemsLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}