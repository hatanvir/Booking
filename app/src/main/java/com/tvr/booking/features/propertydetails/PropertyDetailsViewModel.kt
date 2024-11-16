package com.tvr.booking.features.propertydetails

import androidx.lifecycle.ViewModel
import com.tvr.booking.data.models.Property
import com.tvr.booking.features.propertydetails.adapters.DetailImageViewPagerAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * Created By Tanvir Hasan on 11/15/24 11:07 PM
 * Email: tanvirhasan553@gmail.com
 */

@HiltViewModel
class PropertyDetailsViewModel @Inject constructor() : ViewModel() {
    lateinit var property: Property


}