package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.PhotoResultLayoutBinding
import com.netset.models.PhotoResultDataItems

class PhotoResultAdapter(private val context: Context, private val photoResultDataItems:ArrayList<PhotoResultDataItems>): RecyclerView.Adapter<PhotoResultAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= PhotoResultLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return photoResultDataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.typeFacingText.text = photoResultDataItems[position].type

        val childList=photoResultDataItems[position].childList
        val nestedAdapter = NestedPhotoResultAdapter(context,childList)
        holder.binding.nestedPhotoResultRecyclerView.adapter = nestedAdapter

    }

    class ViewHolder(val binding: PhotoResultLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}