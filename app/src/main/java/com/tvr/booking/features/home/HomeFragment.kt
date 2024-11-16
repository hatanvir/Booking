package com.tvr.booking.features.home

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.tvr.booking.R
import com.tvr.booking.databinding.FragmentHomeBinding
import com.tvr.booking.features.allproperty.AllPropertyActivity
import com.tvr.booking.features.propertydetails.PropertyDetailsActivity
import com.tvr.booking.utilities.AppKeys
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


/**
 * Created By Tanvir Hasan on 11/13/24 10:22 PM
 * Email: tanvirhasan553@gmail.com
 */

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        binding.seeAllTv.setOnClickListener {
            startActivity(Intent(requireActivity(), AllPropertyActivity::class.java).apply {
                putExtra(AppKeys.PROPERTIES, ArrayList(viewModel.propertyList))
            })
        }

        binding.appCompatEditText.setOnClickListener {
            binding.appCompatEditText.requestFocus()
        }

        handleSelectedProperty()
        return binding.root
    }

    private fun handleSelectedProperty() {
        lifecycleScope.launch {
            viewModel.selectedProperty.collect{
                startActivity(Intent(requireActivity(), PropertyDetailsActivity::class.java).apply {
                    putExtra(AppKeys.PROPERTY, it)
                })
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.activity = requireActivity()
        binding.lifecycleOwner = this.viewLifecycleOwner
        binding.viewmodel = viewModel
    }


}