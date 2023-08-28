package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.fragments.MealDetailsFragment
import com.netset.fitness.R
import com.netset.fitness.databinding.PopularItemsLayoutBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.PopularDataItems

class PopularDataAdapter(private val context: Context, private val popularDataItems:ArrayList<PopularDataItems>): RecyclerView.Adapter<PopularDataAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= PopularItemsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return popularDataItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.backgroundImg.setImageResource(popularDataItems[position].foodIconImg)
        holder.binding.foodNamesText.text=popularDataItems[position].foodItemName
        holder.binding.typesText.text = popularDataItems[position].typesNames
        holder.binding.minutesText.text=popularDataItems[position].minutes
        holder.binding.caloriesText.text=popularDataItems[position].calories

        holder.binding.cardView.setOnClickListener {

            CommonFunction.openFragment((context as AppCompatActivity).supportFragmentManager,
                MealDetailsFragment(),R.id.dashboardContainerView,true)

        }
    }





    class ViewHolder(val binding: PopularItemsLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
