package com.netset.fitness

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.adapters.FoodTypeAdapter
import com.netset.fitness.adapters.GalleryAdapter
import com.netset.fitness.databinding.FragmentProgressPhotoBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.FoodTypeDataItems
import com.netset.models.GalleryDataItems
import com.netset.models.PopularDataItems
import com.netset.models.RecommendationDataItems


class ProgressPhotoFragment : Fragment() {
    private lateinit var binding:FragmentProgressPhotoBinding
    private var galleryList:ArrayList<GalleryDataItems> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProgressPhotoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressPhotoToolbar.fragmentsText.text="Progress Photo"

        binding.checkIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,ComparisonFragment(),R.id.dashboardContainerView,true)
        }

        galleryDataShow()
    }

    private fun galleryDataShow() {
        galleryList.add(
                GalleryDataItems("2 June", arrayListOf(
                GalleryDataItems.NestedGalleryDataItems(R.drawable.gym_icon),
                GalleryDataItems.NestedGalleryDataItems(R.drawable.girls_running_icon),
                GalleryDataItems.NestedGalleryDataItems(R.drawable.yoga_girl_icon),
                GalleryDataItems.NestedGalleryDataItems(R.drawable.gym_icon),)))
        galleryList.add(
                GalleryDataItems("5 May", arrayListOf(
                GalleryDataItems.NestedGalleryDataItems(R.drawable.exercise_girl_icon),
                GalleryDataItems.NestedGalleryDataItems(R.drawable.gym_yoga_icon),
                GalleryDataItems.NestedGalleryDataItems(R.drawable.girl_down_icon),
                    GalleryDataItems.NestedGalleryDataItems(R.drawable.exercise_girl_icon),)))



        binding.galleryRecyclerView.setHasFixedSize(true)
        binding.galleryRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        val galleryAdapter = GalleryAdapter(requireContext(), galleryList)
        binding.galleryRecyclerView.adapter = galleryAdapter
    }

}