package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.NestedGalleryLayoutBinding
import com.netset.models.GalleryDataItems

class NestedGalleryAdapter(private val context: Context, private val nestedGalleryItems:ArrayList<GalleryDataItems.NestedGalleryDataItems>): RecyclerView.Adapter<NestedGalleryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= NestedGalleryLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nestedGalleryItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.galleryImg.setImageResource(nestedGalleryItems[position].galleryImage)


    }

    class ViewHolder(val binding: NestedGalleryLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}