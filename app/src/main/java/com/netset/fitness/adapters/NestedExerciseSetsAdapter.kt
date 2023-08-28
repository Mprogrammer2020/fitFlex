package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.NestedExerciseSetsLayoutBinding
import com.netset.models.ExerciseSetItems
import com.netset.models.NestedExerciseSetsItems

class NestedExerciseSetsAdapter(private val context: Context, private val nestedExerciseSetItems:ArrayList<ExerciseSetItems.NestedExerciseSetsItems>): RecyclerView.Adapter<NestedExerciseSetsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= NestedExerciseSetsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return nestedExerciseSetItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.exerciseIcon.setImageResource(nestedExerciseSetItems[position].exerciseIcon)
        holder.binding.exercisesNameText.text=nestedExerciseSetItems[position].exerciseNames
        holder.binding.timesText.text=nestedExerciseSetItems[position].times

    }

    class ViewHolder(val binding: NestedExerciseSetsLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}