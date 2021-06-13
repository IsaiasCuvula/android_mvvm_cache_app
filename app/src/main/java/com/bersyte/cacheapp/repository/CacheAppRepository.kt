package com.bersyte.cacheapp.repository

import com.bersyte.cacheapp.api.ApiService
import com.bersyte.cacheapp.db.CountryDao
import com.bersyte.cacheapp.models.Countries
import com.bersyte.cacheapp.utils.Resource
import com.bersyte.cacheapp.utils.networkBoundResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CacheAppRepository
@Inject constructor(
    private val apiService: ApiService,
    private val dao: CountryDao
) {

     fun getCountries(): Flow<Resource<Countries>> {
        return networkBoundResource(
            fetchFromLocal = { dao.getAllCountries() },
            shouldFetchFromRemote = { it == null },
            fetchFromRemote = { apiService.getAllCountries() },
            processRemoteResponse = { },
            saveRemoteData = { dao.addCountries(it) },
            onFetchFailed = { _, _ -> }
        ).flowOn(Dispatchers.IO)
    }

}