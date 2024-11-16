package com.tvr.booking.features.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tvr.booking.data.models.Property
import com.tvr.booking.databinding.ItemPropertyBinding
import com.tvr.booking.listeners.ItemClickListener

/**
 * Created By Tanvir Hasan on 11/14/24 11:42 PM
 * Email: tanvirhasan553@gmail.com
 */
class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {
    private var properties = emptyList<Property>()
    private lateinit var itemClickListener: ItemClickListener

    fun setData(properties: List<Property>, itemClickListener: ItemClickListener) {
        this.properties = properties
        this.itemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PropertyViewHolder {
        return PropertyViewHolder(
            ItemPropertyBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return properties.size
    }

    override fun onBindViewHolder(holder: PropertyViewHolder, position: Int) {
        holder.bind(properties[position], itemClickListener)
    }

    class PropertyViewHolder(private var itemPropertyBinding: ItemPropertyBinding) :
        ViewHolder(itemPropertyBinding.root) {
        fun bind(property: Property, itemClickListener: ItemClickListener) {
            itemPropertyBinding.property = property
            itemPropertyBinding.root.setOnClickListener {
                itemClickListener.onClick(property)
            }
        }
    }
}

