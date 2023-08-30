package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.NotificationLayoutBinding
import com.netset.models.NotificationData

class NotificationAdapter(private val context: Context, private val notificationsItems:ArrayList<NotificationData>): RecyclerView.Adapter<NotificationAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= NotificationLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notificationsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.binding.backgroundImg.setImageResource(notificationsItems[position].imageBackground)
        holder.binding.notificationTitleText.text=notificationsItems[position].title
        holder.binding.aboutText.text=notificationsItems[position].minutesAndHour

        if (position==notificationsItems.size-1)
        {
            holder.binding.view.visibility=View.GONE
        }else{
            holder.binding.view.visibility=View.VISIBLE

        }


    }

    class ViewHolder(val binding: NotificationLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}