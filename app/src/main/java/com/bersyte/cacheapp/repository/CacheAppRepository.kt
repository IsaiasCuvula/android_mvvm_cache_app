package com.bersyte.cacheapp.repository

import com.bersyte.cacheapp.api.ApiService
import javax.inject.Inject

class CacheAppRepository
@Inject constructor(private val apiService: ApiService) {

    suspend fun getAllCountries() = apiService.getAllCountries()

}