package com.tvr.booking.data.repository

import com.tvr.booking.BookingApplication
import com.tvr.booking.R
import com.tvr.booking.base.ViewState
import com.tvr.booking.data.models.Property
import com.tvr.booking.data.remote.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * Created By Tanvir Hasan on 11/13/24 10:31 PM
 * Email: tanvirhasan553@gmail.com
 */
class PropertyRepo @Inject constructor(private var apiInterface: ApiInterface) {
    suspend fun getProperty() = flow {
        emit(ViewState.Loading)
        val propertyResponse = apiInterface.getProperty()
        if (propertyResponse.isSuccessful) {
            emit(ViewState.Success(propertyResponse.body()))
        } else {
            emit(ViewState.Error(propertyResponse.message()))
        }
    }.catch {
        emit(
            ViewState.Error(
                it.message ?: BookingApplication.instance.getString(R.string.something_went_wrong)
            )
        )
    }.flowOn(Dispatchers.IO)
}