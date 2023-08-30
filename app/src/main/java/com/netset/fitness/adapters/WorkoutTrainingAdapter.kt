package com.netset.fitness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.netset.fitness.R
import com.netset.fitness.fragments.WorkoutDetailsFragment
import com.netset.fitness.databinding.WorkoutTrainingLayoutBinding
    import com.netset.models.WorkoutTrainingItems

class WorkoutTrainingAdapter(private val context: Context, private val workoutTrainingItems:ArrayList<WorkoutTrainingItems>): RecyclerView.Adapter<WorkoutTrainingAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= WorkoutTrainingLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return workoutTrainingItems.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.workoutNameText.text=workoutTrainingItems[position].workoutNames
        holder.binding.exerciseText.text=workoutTrainingItems[position].excercise
        holder.binding.minutesText.text=workoutTrainingItems[position].minutes
        holder.binding.workoutIcon.setImageResource(workoutTrainingItems[position].workoutIcon)


        holder.binding.workoutTrainBackground.setOnClickListener {
            val transaction =(context as AppCompatActivity).supportFragmentManager.beginTransaction().addToBackStack("")
                .replace(R.id.dashboardContainerView, WorkoutDetailsFragment())
            transaction.commit()

        }
    }

    class ViewHolder(val binding: WorkoutTrainingLayoutBinding): RecyclerView.ViewHolder(binding.root) {

    }
}