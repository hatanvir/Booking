package com.tvr.booking.features.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.tvr.booking.data.models.Category
import com.tvr.booking.databinding.ItemCategoryBinding

/**
 * Created By Tanvir Hasan on 11/14/24 11:42 PM
 * Email: tanvirhasan553@gmail.com
 */
class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var categories = emptyList<Category>()
    fun setData(categories: List<Category>) {
        this.categories = categories
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    class CategoryViewHolder(private var itemCategoryBinding: ItemCategoryBinding) :
        ViewHolder(itemCategoryBinding.root) {
        fun bind(category: Category){
            itemCategoryBinding.category = category
        }
    }
}


