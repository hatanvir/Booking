package com.tvr.booking.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.tvr.booking.R
import com.tvr.booking.databinding.ActivityMainBinding
import com.tvr.booking.features.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created By Tanvir Hasan on 11/13/24 10:22 PM
 * Email: tanvirhasan553@gmail.com
 */

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupBottomNav()
    }

    private fun setupBottomNav() {
        setupFragment(HomeFragment())
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {

                    true
                }

                R.id.bookmarks -> {

                    true
                }

                R.id.notifications -> {

                    true
                }

                R.id.profile -> {

                    true
                }

                else -> false
            }
        }
    }

    private fun setupFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
