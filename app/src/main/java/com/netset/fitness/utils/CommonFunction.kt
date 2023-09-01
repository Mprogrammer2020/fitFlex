package com.netset.fitness.utils

import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.netset.fitness.fragments.MealScheduleFragment

class CommonFunction {

    companion object {


        fun openFragment(fragmentManager: FragmentManager, fragment: Fragment, containerId: Int, addToBackStack: Boolean = true) {
            val transaction: FragmentTransaction = fragmentManager.beginTransaction()
            transaction.replace(containerId, fragment)
            if (addToBackStack) { transaction.addToBackStack(null) }
            transaction.commit()
        }
    }


        fun showToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }

        fun isConnectedToInternet(context: Context): Boolean {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo != null && networkInfo.isConnected
        }

    }
