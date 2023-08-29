package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.NotificationAdapter
import com.netset.fitness.databinding.FragmentNotificationBinding
import com.netset.models.NotificationData


class NotificationFragment : Fragment() {
    private  lateinit var binding:FragmentNotificationBinding
    private var list:ArrayList<NotificationData> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNotificationBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)


        binding.backIconBackground.setOnClickListener {
             requireActivity().onBackPressedDispatcher.onBackPressed()
         }

        notificationDataShow()

    }

    private fun notificationDataShow() {
        list.clear()
        list.add(NotificationData(R.drawable.meal_background,"Hey, it’s time for lunch","About 1 minutes ago"))
        list.add(NotificationData(R.drawable.girl_gym_background,"Don’t miss your lowerbody workout","About 3 hours ago"))
        list.add(NotificationData(R.drawable.meal_background,"Hey, let’s add some meals for your b..","About 3 hours ago"))
        list.add(NotificationData(R.drawable.gym_boy_background,"Congratulations, You have finished A..","29 May"))
        list.add(NotificationData(R.drawable.girl_gym_background,"Hey, it’s time for lunch","29 April"))
        list.add(NotificationData(R.drawable.gym_boy_background,"Ups, You have missed your Lowerbo...","29 May"))

        binding.notificationRecyclerView.setHasFixedSize(true)
        binding.notificationRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = NotificationAdapter(requireContext(), list)
        binding.notificationRecyclerView.adapter = adapter
    }


}