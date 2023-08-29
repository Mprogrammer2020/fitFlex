package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.FoodTypeLayoutBinding
import com.netset.fitness.databinding.GalleryLayoutBinding
import com.netset.models.FoodTypeDataItems
import com.netset.models.GalleryDataItems

class GalleryAdapter(private val context: Context, private val galleryDataItems:ArrayList<GalleryDataItems>): RecyclerView.Adapter<GalleryAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= GalleryLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return galleryDataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.dateMonthText.text = galleryDataItems[position].dayMonth


        val childList=galleryDataItems[position].nestedGalleryList
        val nestedAdapter = NestedGalleryAdapter(context,childList)
        holder.binding.nestedGalleryRecyclerView.adapter = nestedAdapter

    }


    class ViewHolder(val binding: GalleryLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}