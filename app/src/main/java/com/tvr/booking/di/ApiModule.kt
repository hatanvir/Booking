package com.tvr.booking.di

import com.tvr.booking.data.remote.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

/**
 * Created By Tanvir Hasan on 11/13/24 10:22 PM
 * Email: tanvirhasan553@gmail.com
 */

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    internal fun apiService(retrofit: Retrofit) = retrofit.create(ApiInterface::class.java)
}