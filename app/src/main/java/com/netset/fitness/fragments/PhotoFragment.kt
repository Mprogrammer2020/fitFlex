package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.adapters.PhotoResultAdapter
import com.netset.fitness.databinding.FragmentPhotoBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.PhotoResultDataItems


class PhotoFragment : Fragment() {

    private lateinit var binding:FragmentPhotoBinding
    private var photoResultList:ArrayList<PhotoResultDataItems> = ArrayList()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPhotoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),
            R.color.white
        )


        binding.backButton.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,HomeFragment(),
                R.id.dashboardContainerView,false)
        }

        photoResultDataShow()
    }

    private fun photoResultDataShow() {

        photoResultList.add(
            PhotoResultDataItems("Front Facing", arrayListOf(
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.gym_icon),
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.exercise_girl_icon),)))

        photoResultList.add(
            PhotoResultDataItems("Back Facing", arrayListOf(
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.back_facing_icon),
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.yoga_girl_icon),)))


        photoResultList.add(
            PhotoResultDataItems("Left Facing", arrayListOf(
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.girls_running_icon),
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.girl_down_icon),)))

        photoResultList.add(
            PhotoResultDataItems("Right Facing", arrayListOf(
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.gym_yoga_icon),
                PhotoResultDataItems.NestedPhotoResultDataItems(R.drawable.right_facing_icon),)))



        binding.photoResultRecyclerView.setHasFixedSize(true)
        binding.photoResultRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val photoResultAdapter = PhotoResultAdapter(requireContext(), photoResultList)
        binding.photoResultRecyclerView.adapter = photoResultAdapter
    }
}