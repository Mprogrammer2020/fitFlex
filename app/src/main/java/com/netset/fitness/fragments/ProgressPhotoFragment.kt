package com.netset.fitness.fragments

import android.graphics.Color
import android.graphics.LinearGradient
import android.graphics.Shader
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.GalleryAdapter
import com.netset.fitness.databinding.FragmentProgressPhotoBinding
import com.netset.fitness.utils.CommonFunction
import com.netset.models.GalleryDataItems


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

        (activity as DashBoardActivity?)?.showHideBottomBar(true)
        requireActivity().window.statusBarColor= ContextCompat.getColor(requireContext(),
            R.color.white
        )

        binding.progressPhotoToolbar.fragmentsText.text="Progress Photo"


        val spannable = SpannableString("Track Your Progress Each \nMonth With Photo")

        val loginClickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {

            }
            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                val shader = LinearGradient(0f, 0f, ds.measureText("Login"), ds.textSize, intArrayOf(
                    ContextCompat.getColor(requireContext(), R.color.pale_blue),
                    ContextCompat.getColor(requireContext(), R.color.light_blue)
                ), null, Shader.TileMode.CLAMP)
                ds.shader = shader
                ds.isUnderlineText = false
            }
        }

        val startIndex = spannable.indexOf("Photo")
        val endIndex = startIndex + "Photo".length

        spannable.setSpan(loginClickableSpan, startIndex, endIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.progressMonthPhotoText.text = spannable
        binding.progressMonthPhotoText.highlightColor = Color.TRANSPARENT
        binding.progressMonthPhotoText.movementMethod = LinkMovementMethod.getInstance()





        binding.compareIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                ComparisonFragment(), R.id.dashboardContainerView,true)
        }

        binding.cameraIcon.setOnClickListener {
            CommonFunction.openFragment(requireActivity().supportFragmentManager,
                TakePhotoFragment(),
                R.id.dashboardContainerView,true)

        }

        galleryDataShow()
    }

    private fun galleryDataShow() {
        galleryList.clear()
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