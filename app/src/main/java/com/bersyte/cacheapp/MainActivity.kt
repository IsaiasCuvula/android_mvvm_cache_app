package com.bersyte.cacheapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.bersyte.cacheapp.adapter.CacheAppAdapter
import com.bersyte.cacheapp.databinding.ActivityMainBinding
import com.bersyte.cacheapp.utils.Resource
import com.bersyte.cacheapp.viewmodel.CacheAppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: CacheAppViewModel by viewModels()
    private lateinit var cacheAppAdapter: CacheAppAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        populateUI()
    }


    private fun populateUI() {
        cacheAppAdapter = CacheAppAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = cacheAppAdapter
        }


        viewModel.countriesResponse.observe(this, { countries ->
            cacheAppAdapter.countries = countries

            /*binding.apply {

                progressBar.isVisible = countries is Resource.Loading && countries.isNullOrEmpty()
                tvErrorMessage.isVisible = countries is Resource.Failure && countries.isNullOrEmpty()
                tvErrorMessage.text = countries
            }*/


        })
    }


}

































