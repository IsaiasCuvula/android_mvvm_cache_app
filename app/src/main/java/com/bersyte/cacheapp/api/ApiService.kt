package com.bersyte.cacheapp.api

import com.bersyte.cacheapp.models.Countries
import com.bersyte.cacheapp.utils.Constants.END_POINT
import com.bersyte.cacheapp.utils.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(END_POINT)
    fun getAllCountries(): Flow<ApiResponse<Countries>>
}