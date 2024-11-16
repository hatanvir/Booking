package com.tvr.booking.features.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.tvr.booking.R

/**
 * Created By Tanvir Hasan on 11/15/24 12:33 AM
 * Email: tanvirhasan553@gmail.com
 */

/**
 * loading image here
 */
@BindingAdapter("loadImage", requireAll = false)
fun loadImage(imageView: ImageView, image: String?) {
    Glide
        .with(imageView.context)
        .load(image)
        .placeholder(R.drawable.placeholder_image)
        .into(imageView)
}