package com.tvr.booking.features.propertydetails.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tvr.booking.databinding.ItemDetailImagePagerBinding

/**
 * Created By Tanvir Hasan on 11/15/24 11:32 PM
 * Email: tanvirhasan553@gmail.com
 */
class DetailImageViewPagerAdapter : RecyclerView.Adapter<DetailImageViewPagerAdapter.PagerViewHolder>() {
    var images = emptyList<String>()
    fun setData(images: List<String>) {
        this.images = images
        println(images)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        return PagerViewHolder(
            ItemDetailImagePagerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(images[position])
    }

    class PagerViewHolder(private var itemDetailImagePagerBinding: ItemDetailImagePagerBinding) :
        ViewHolder(itemDetailImagePagerBinding.root) {
        fun bind(image: String) {
            itemDetailImagePagerBinding.image = image
        }
    }

}


