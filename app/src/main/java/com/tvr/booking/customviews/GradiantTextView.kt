package com.tvr.booking.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.LinearGradient
import android.graphics.Shader
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.tvr.booking.R


/**
 * Created By Tanvir Hasan on 11/16/24 6:57 PM
 * Email: tanvirhasan553@gmail.com
 */

class GradientTextView : androidx.appcompat.widget.AppCompatTextView {
    constructor(context: Context?) : super(context!!)

    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context!!,
        attrs,
        defStyleAttr
    )

    @SuppressLint("DrawAllocation")
    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        if (changed) {
            paint.setShader(
                LinearGradient(
                    0f, 0f, width.toFloat(), height.toFloat(),
                    ContextCompat.getColor(context, R.color.orange),
                    ContextCompat.getColor(context, R.color.white_orange),
                    Shader.TileMode.CLAMP
                )
            )
        }
    }
}