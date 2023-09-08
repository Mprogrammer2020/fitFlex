package com.netset.fitness.fragments

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.netset.fitness.R
import com.netset.fitness.activities.DashBoardActivity
import com.netset.fitness.adapters.AvatarAdapter
import com.netset.fitness.databinding.FragmentTakePhotoBinding
import com.netset.models.AvatarDataItems


class TakePhotoFragment : Fragment(),AvatarAdapter.PassImage {
    private lateinit var binding:FragmentTakePhotoBinding
    private var avatarList:ArrayList<AvatarDataItems> = ArrayList()

    private lateinit var requestCameraPermissionLauncher: ActivityResultLauncher<String>
    private lateinit var requestCameraLauncher: ActivityResultLauncher<Intent>
    private var permissionDeniedCount = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTakePhotoBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as DashBoardActivity?)?.showHideBottomBar(false)

        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)


        binding.cameraIcon.setOnClickListener {
            requestCameraPermission()
        }

        requestCameraPermissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (isGranted) {
                openCamera()
            }
            permissionDeniedCount++
            if (permissionDeniedCount >= 2) {
                showPermissionDeniedDialog()
            } else {

            }
        }

        requestCameraLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                val imageBitmap = data?.extras?.get("data") as Bitmap?
                if (imageBitmap != null) {
                 //   binding.avatarIcon.setImageBitmap(imageBitmap)
                }
            }
        }

        avatarDataShow()

    }

    private fun openCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        requestCameraLauncher.launch(intent)
    }

    private fun requestCameraPermission() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            openCamera()
        }
        else {
            requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
        }
    }

    fun showPermissionDeniedDialog() {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Permission Required")
        alertDialog.setMessage("To use the camera, you need to grant camera permission from the app settings.")
        alertDialog.setPositiveButton("Open Settings") { _, _ ->
            openAppSettings()
        }
        alertDialog.setNegativeButton("Cancel") { _, _ ->
            // Handle cancel action if needed
        }
        alertDialog.show()
    }

    private fun openAppSettings() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.data = Uri.fromParts("package", "com.netset.fitness", null)
        startActivity(intent)
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