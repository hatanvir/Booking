package com.tvr.booking.features.allproperty

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvr.booking.data.models.Property
import com.tvr.booking.features.allproperty.adapters.AllPropertyAdapter
import com.tvr.booking.listeners.ItemClickListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Tanvir Hasan on 11/15/24 8:56 AM
 * Email: tanvirhasan553@gmail.com
 */
@HiltViewModel
class AllPropertyViewModel @Inject constructor(): ViewModel(),ItemClickListener {
    var allPropertyAdapter = AllPropertyAdapter()
    var selectedProperty = MutableSharedFlow<Property>()

    fun setupData(properties:List<Property>){
        allPropertyAdapter.setData(properties,this)
        allPropertyAdapter.notifyDataSetChanged()
    }

    override fun onClick(data: Any) {
        viewModelScope.launch {
            selectedProperty.emit(data as Property)
        }
    }
}