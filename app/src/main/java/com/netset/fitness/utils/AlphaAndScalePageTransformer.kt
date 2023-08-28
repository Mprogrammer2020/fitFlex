package com.netset.fitness.utils

import android.view.View
import androidx.viewpager.widget.ViewPager
import java.lang.Math.abs


class AlphaAndScalePageTransformer : ViewPager.PageTransformer {
    private val SCALE_MAX = 0.8f
    private val ALPHA_MAX = 0.5f

    override fun transformPage(page: View, position: Float) {
        when {
            position < -1 -> { // Off to the left
                page.scaleX = SCALE_MAX
                page.scaleY = SCALE_MAX
                page.alpha = ALPHA_MAX
            }
            position <= 1 -> { // Visible pages
                val scaleFactor = SCALE_MAX + (1 - abs(position)) * (1 - SCALE_MAX)
                val alphaFactor = ALPHA_MAX + (1 - abs(position)) * (1 - ALPHA_MAX)

                page.scaleX = scaleFactor
                page.scaleY = scaleFactor
                page.alpha = alphaFactor
            }
            else -> { // Off to the right
                page.scaleX = SCALE_MAX
                page.scaleY = SCALE_MAX
                page.alpha = ALPHA_MAX
            }
        }
    }
}
