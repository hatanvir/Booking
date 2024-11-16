package com.tvr.booking.features.propertydetails

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.tvr.booking.R
import com.tvr.booking.data.models.Property
import com.tvr.booking.databinding.ActivityAllPropertyBinding
import com.tvr.booking.databinding.ActivityPropertyDetailsBinding
import com.tvr.booking.features.propertydetails.adapters.DetailImageViewPagerAdapter
import com.tvr.booking.utilities.AppKeys
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PropertyDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityPropertyDetailsBinding
    lateinit var viewmodel: PropertyDetailsViewModel

    var detailImageViewPagerAdapter = DetailImageViewPagerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewmodel = ViewModelProvider(this)[PropertyDetailsViewModel::class]

        val property = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(AppKeys.PROPERTY, Property::class.java)
        } else {
            intent.getParcelableExtra(AppKeys.PROPERTY)
        }

        if (property != null) {
            binding.property = property
            property.detail_images?.let { detailImageViewPagerAdapter.setData(it) }
            binding.imageViewPager.adapter = detailImageViewPagerAdapter
            setupTabLayoutAndViewpager()
        }

        binding.buttonBack.setOnClickListener {
            finish()
        }
    }

    private fun setupTabLayoutAndViewpager() {
        TabLayoutMediator(binding.tabLayout, binding.imageViewPager) { tab, position ->
            tab.setCustomView(R.layout.tab_indicator)
        }.attach()

        binding.imageViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                updateTabLayout(binding.tabLayout, position)
            }
        })
    }

    private fun updateTabLayout(tabLayout: TabLayout, selectedPosition: Int) {
        for (i in 0 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val indicator = tab?.customView?.findViewById<View>(R.id.indicator_dot)
            if (i == selectedPosition) {
                indicator?.setBackgroundResource(R.drawable.selected_indicator)
            } else {
                indicator?.setBackgroundResource(R.drawable.unselected_indicator)
            }
        }
    }
}