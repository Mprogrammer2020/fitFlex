package com.netset.fitness.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import com.netset.fitness.R

class CustomCircleIndicatorView(context: Context, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {

    private val circleRadius = 16f // Circle ka radius
    private val circleSpacing = 12f // Circle ke beech ka spacing
    var selectedCircleColor = ContextCompat.getColor(context, R.color.light_blue)
    var unselectedCircleColor =ContextCompat.getColor(context, R.color.dotColor)
    private val circleCount = 3 // Total circles

    private val circlePaint = Paint()
    private var selectedCircleIndex = 0 // Current select circle index

    init {
        orientation = HORIZONTAL
        circlePaint.isAntiAlias = true
        circlePaint.style = Paint.Style.FILL

        // Calculate the total width of a circle with spacing
        val totalCircleWidth = (2 * circleRadius + circleSpacing) * circleCount - circleSpacing

        // Circle Views ko add karen
        for (i in 0 until circleCount) {
            val circleView = CircleView(context)

            // Calculate the left and right margins to add spacing between circles
            val leftMargin = if (i > 0) circleSpacing.toInt() else 0
            val rightMargin = if (i < circleCount - 1) circleSpacing.toInt() else 0

            val layoutParams = LayoutParams(
                (2 * circleRadius).toInt(),
                (2 * circleRadius).toInt()
            )
            layoutParams.setMargins(leftMargin, 0, rightMargin, 0)
            circleView.layoutParams = layoutParams

            addView(circleView)
            circleView.setOnClickListener {
                // Circle par click karne par select/unselect toggle karen
                selectedCircleIndex = i
                updateCircleViews()
            }
        }
        updateCircleViews()
    }

    private inner class CircleView(context: Context) : View(context) {
        override fun onDraw(canvas: Canvas?) {
            super.onDraw(canvas)
            // Circle ko draw karen
            val cx = width / 2f
            val cy = height / 2f
            val radius = circleRadius
            circlePaint.color =
                if (selectedCircleIndex == indexOfChild(this)) selectedCircleColor else unselectedCircleColor
            canvas?.drawCircle(cx, cy, radius, circlePaint)
        }
    }

    // Circle views ko update karen
    private fun updateCircleViews() {
        for (i in 0 until childCount) {
            val child = getChildAt(i) as CircleView
            child.invalidate()
        }
    }

    // Position ko update karen
    fun updatePosition(position: Int) {
        if (position in 0 until circleCount) {
            selectedCircleIndex = position
            updateCircleViews()
        }

    }
}