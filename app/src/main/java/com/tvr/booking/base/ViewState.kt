package com.tvr.booking.base

/**
 * Created By Tanvir Hasan on 11/14/24 10:09 PM
 * Email: tanvirhasan553@gmail.com
 *
 * sealed class for handling ui state
 */
sealed interface ViewState<out T> {
    data class Success<T>(val data:T?): ViewState<T>
    data class Error<T>(val message:String?): ViewState<Nothing>
    data object Loading: ViewState<Nothing>
}