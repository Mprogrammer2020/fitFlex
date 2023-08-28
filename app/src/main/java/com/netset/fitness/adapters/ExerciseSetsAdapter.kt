package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.databinding.ExerciseSetsLayoutBinding
import com.netset.models.ExerciseSetItems
import com.netset.models.LatestWorkoutItems
import com.netset.models.NestedExerciseSetsItems

class ExerciseSetsAdapter(private val context: Context, private val exerciseSetsItems:ArrayList<ExerciseSetItems>): RecyclerView.Adapter<ExerciseSetsAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= ExerciseSetsLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return exerciseSetsItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.setsText.text = exerciseSetsItems[position].exerciseSets

        val childList=exerciseSetsItems[position].childList
        val nestedAdapter = NestedExerciseSetsAdapter(context,childList)
        holder.binding.setsExerciseRecyclerView.adapter = nestedAdapter

    }



    class ViewHolder(val binding: ExerciseSetsLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}
