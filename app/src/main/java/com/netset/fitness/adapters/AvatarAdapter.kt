package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.AvatarLayoutBinding
import com.netset.models.AvatarDataItems

class AvatarAdapter(private val context: Context, private val avatarItems:ArrayList<AvatarDataItems>,val passImage: PassImage): RecyclerView.Adapter<AvatarAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= AvatarLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

     interface PassImage{
         fun dataPassing(position:Int)
     }


    override fun getItemCount(): Int {
        return avatarItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.avatarImage.setImageResource(avatarItems[position].avatarImage)

      holder.binding.avatarBackground.setOnClickListener {
          passImage.dataPassing(position)
      }

    }

    class ViewHolder(val binding: AvatarLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}