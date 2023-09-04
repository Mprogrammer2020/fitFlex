package com.netset.fitness.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.AvatarAdapter
import com.netset.fitness.databinding.FragmentTakePhotoBinding
import com.netset.models.AvatarDataItems

class TakePhotoFragment : Fragment(),AvatarAdapter.PassImage {
    private lateinit var binding:FragmentTakePhotoBinding
    private var avatarList:ArrayList<AvatarDataItems> = ArrayList()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTakePhotoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)
//        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
//            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN)

        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

        avatarDataShow()

    }

    private fun avatarDataShow() {

        avatarList.clear()
        avatarList.add(AvatarDataItems(R.drawable.front_avatar))
        avatarList.add(AvatarDataItems(R.drawable.left_avatar))
        avatarList.add(AvatarDataItems(R.drawable.grey_avatar))
        avatarList.add(AvatarDataItems(R.drawable.right_avatar))

        binding.avatarRecyclerView.setHasFixedSize(true)
        binding.avatarRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
        val avatarAdapter = AvatarAdapter(requireContext(), avatarList,this)
        binding.avatarRecyclerView.adapter = avatarAdapter
    }

    override fun dataPassing(position: Int) {
        val selectedAvatarImage = avatarList[position].avatarImage
        binding.avatarIcon.setImageResource(selectedAvatarImage)

    }

    override fun onDetach() {
        super.onDetach()
        requireActivity().window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
    }

}