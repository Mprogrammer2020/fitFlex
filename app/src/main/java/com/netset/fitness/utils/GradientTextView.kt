package com.netset.fitness.utils

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.netset.fitness.R

class GradientTextView : AppCompatTextView {
     var mContext: Context

    constructor(context: Context) : super(context) {
        this.mContext = context
        init() // Initialize gradient colors and shader
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        this.mContext = context
        init() // Initialize gradient colors and shader
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
        this.mContext = context
        init() // Initialize gradient colors and shader
    }

    private fun init() {
        // Set initial gradient colors and shader
        changeGradientColors(
            ContextCompat.getColor(context, R.color.pale_blue),
            ContextCompat.getColor(context, R.color.light_blue)
        )
    }

    override fun onDraw(canvas: Canvas) {
        // The gradient colors and shader are already set in the init() method
        super.onDraw(canvas)
    }

    fun changeGradientColors(startColor: Int, endColor: Int) {
        val textShader: Shader = LinearGradient(
            0f,
            0f,
            textSize,
            paint.measureText(text.toString()),
            intArrayOf(startColor, endColor),
            floatArrayOf(0f, 1f),
            Shader.TileMode.CLAMP
        )
        paint.shader = textShader
        setTextColor(startColor) // Set initial color as startColor
//        background = null
        invalidate()
    }
}