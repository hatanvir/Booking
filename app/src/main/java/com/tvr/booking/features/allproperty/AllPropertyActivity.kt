package com.tvr.booking.features.allproperty

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.tvr.booking.R
import com.tvr.booking.data.models.Property
import com.tvr.booking.databinding.ActivityAllPropertyBinding
import com.tvr.booking.features.propertydetails.PropertyDetailsActivity
import com.tvr.booking.utilities.AppKeys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllPropertyActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllPropertyBinding
    private lateinit var viewModel: AllPropertyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllPropertyBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[AllPropertyViewModel::class.java]
        setContentView(binding.root)


        val propertyList = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableArrayListExtra(AppKeys.PROPERTIES, Property::class.java)
        } else {
            intent.getParcelableArrayListExtra<Property>(AppKeys.PROPERTIES)
        }
        if (propertyList != null) {
            viewModel.setupData(propertyList)
        }

        binding.viewmodel = viewModel

        binding.backIm.setOnClickListener {
            finish()
        }

        handleSelectedProperty()
    }

    private fun handleSelectedProperty() {
        lifecycleScope.launch {
            viewModel.selectedProperty.collect{
                startActivity(Intent(this@AllPropertyActivity, PropertyDetailsActivity::class.java).apply {
                    putExtra(AppKeys.PROPERTY, it)
                })
            }
        }
    }
}