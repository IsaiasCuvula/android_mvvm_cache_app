package com.bersyte.cacheapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bersyte.cacheapp.models.Countries
import com.bersyte.cacheapp.repository.CacheAppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CacheAppViewModel
@Inject constructor(private val repository: CacheAppRepository) : ViewModel() {

    private val _response = MutableLiveData<Countries>()
    val countriesResponse: LiveData<Countries>
        get() = _response


    init {
        getAllCountries()
    }


    private fun getAllCountries() = viewModelScope.launch {
        repository.getAllCountries().let { response ->

            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("response error", "getAllCountries: ${response.code()}")
            }

        }
    }

}