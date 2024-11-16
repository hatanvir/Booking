package com.tvr.booking.data.remote

import com.tvr.booking.data.models.Property
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Created By Tanvir Hasan on 11/13/24 9:56 PM
 * Email: tanvirhasan553@gmail.com
 */
interface ApiInterface {
    @GET("/")
    suspend fun getProperty(): Response<List<Property>>

}