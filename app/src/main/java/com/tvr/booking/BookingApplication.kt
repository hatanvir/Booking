package com.tvr.booking

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created By Tanvir Hasan on 11/13/24 10:00 PM
 * Email: tanvirhasan553@gmail.com
 */
@HiltAndroidApp
class BookingApplication: Application() {
    companion object{
        lateinit var instance: BookingApplication
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}