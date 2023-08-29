package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.NestedPhotoResultLayoutBinding
import com.netset.models.PhotoResultDataItems

class NestedPhotoResultAdapter(private val context: Context, private val nestedPhotoItems:ArrayList<PhotoResultDataItems.NestedPhotoResultDataItems>): RecyclerView.Adapter<NestedPhotoResultAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= NestedPhotoResultLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nestedPhotoItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.galleryImg.setImageResource(nestedPhotoItems[position].photoImage)


    }

    class ViewHolder(val binding: NestedPhotoResultLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}