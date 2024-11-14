package com.tvr.booking.di

import android.content.Context
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created By Tanvir Hasan on 11/13/24 10:18 PM
 * Email: tanvirhasan553@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    internal fun retrofit(
        @ApplicationContext context: Context,
        gsonConverterFactory: GsonConverterFactory
    ) = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(gsonConverterFactory)
        .build()

    @Provides
    internal fun gsonConvertFactory() = GsonConverterFactory.create()

}