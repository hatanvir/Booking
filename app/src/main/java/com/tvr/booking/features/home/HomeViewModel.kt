package com.tvr.booking.features.home

import android.util.Log
import androidx.appcompat.content.res.AppCompatResources
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tvr.booking.BookingApplication
import com.tvr.booking.R
import com.tvr.booking.base.ViewState
import com.tvr.booking.data.models.Category
import com.tvr.booking.data.models.Property
import com.tvr.booking.data.repository.PropertyRepo
import com.tvr.booking.features.home.adapters.CategoryAdapter
import com.tvr.booking.features.home.adapters.PropertyAdapter
import com.tvr.booking.listeners.ItemClickListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created By Tanvir Hasan on 11/13/24 9:56 PM
 * Email: tanvirhasan553@gmail.com
 */

@HiltViewModel
class HomeViewModel @Inject constructor(private var propertyRepo: PropertyRepo) : ViewModel(),ItemClickListener {
    var categoryAdapter = CategoryAdapter()
    var propertyAdapter = PropertyAdapter()

    var progressBarVisibility = MutableStateFlow(false)
    var error = MutableStateFlow("")
    var selectedProperty = MutableSharedFlow<Property>()

    var propertyList: List<Property> = emptyList()

    init {
        getCategories()
        getProperties()
    }

    /**
     * populating property here
     */
    private fun getCategories() {
        categoryAdapter.setData(
            listOf(
                Category(
                    BookingApplication.instance.getString(R.string.flight),
                    AppCompatResources.getDrawable(BookingApplication.instance, R.drawable.flight)
                ),
                Category(
                    BookingApplication.instance.getString(R.string.hotels),
                    AppCompatResources.getDrawable(BookingApplication.instance, R.drawable.hotel)
                ),
                Category(
                    BookingApplication.instance.getString(R.string.visa),
                    AppCompatResources.getDrawable(BookingApplication.instance, R.drawable.visa)
                ),
                Category(
                    BookingApplication.instance.getString(R.string.buses),
                    AppCompatResources.getDrawable(BookingApplication.instance, R.drawable.buses)
                )
            )
        )
        categoryAdapter.notifyDataSetChanged()
    }

    /**
     * getting property data from remote
     */
    private fun getProperties() {
        viewModelScope.launch {
            propertyRepo.getProperty().collect {
                when (it) {
                    is ViewState.Loading -> {
                        progressBarVisibility.value = true
                    }

                    is ViewState.Success -> {
                        progressBarVisibility.emit(false)
                        Log.d("SSS", "success ${it.data}")
                        it.data?.let { it1 ->
                            propertyList = it1
                            propertyAdapter.setData(it1,this@HomeViewModel)
                            propertyAdapter.notifyDataSetChanged()
                        }
                    }

                    is ViewState.Error -> {
                        progressBarVisibility.emit(false)
                        error.emit(it.message ?: "Errorx")
                        Log.d("Errr", it.message ?: "ttt")
                    }
                }
            }
        }
    }

    override fun onClick(data: Any) {
        viewModelScope.launch {
            selectedProperty.emit(data as Property)
        }
    }
}