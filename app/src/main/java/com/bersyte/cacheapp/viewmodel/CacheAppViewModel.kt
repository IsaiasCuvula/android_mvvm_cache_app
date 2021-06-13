package com.bersyte.cacheapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bersyte.cacheapp.models.Countries
import com.bersyte.cacheapp.repository.CacheAppRepository
import com.bersyte.cacheapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class CacheAppViewModel
@Inject constructor(repository: CacheAppRepository) : ViewModel() {

    val data: Flow<Resource<Countries>> =
        repository.getCountries().map {

            when (it.status) {
                Resource.Status.LOADING -> {
                    Resource.loading(null)
                }
                Resource.Status.SUCCESS -> {
                    Resource.success(it.data)
                }
                Resource.Status.ERROR -> {
                    Resource.error(it.message!!, null)
                }
            }
        }

}