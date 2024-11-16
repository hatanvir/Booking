package com.tvr.booking.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created By Tanvir Hasan on 11/15/24 12:07 AM
 * Email: tanvirhasan553@gmail.com
 */

@Parcelize
data class Property(
    var property_name: String?,
    var location: String?,
    var rating: Double?,
    var description: String?,
    var fare: Double?,
    var fare_unit: String?,
    var is_available: Boolean?,
    var hero_image: String?,
    val detail_images: List<String>?,
    var currency: String?,
) : Parcelable