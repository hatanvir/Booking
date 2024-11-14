package com.tvr.booking.features.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tvr.booking.R
/**
 * Created By Tanvir Hasan on 11/13/24 10:22 PM
 * Email: tanvirhasan553@gmail.com
 */

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

}