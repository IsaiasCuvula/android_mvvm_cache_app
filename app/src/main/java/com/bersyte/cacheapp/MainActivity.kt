package com.bersyte.cacheapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bersyte.cacheapp.adapter.CacheAppAdapter
import com.bersyte.cacheapp.databinding.ActivityMainBinding
import com.bersyte.cacheapp.viewmodel.CacheAppViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map

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

        viewModel.data.map {
            cacheAppAdapter.countries = it.data!!
        }

    }

}



































