package com.bersyte.cacheapp.repository

import com.bersyte.cacheapp.api.ApiService
import com.bersyte.cacheapp.db.CountryDatabase
import com.bersyte.cacheapp.utils.cacheResource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class CacheAppRepository
@Inject constructor(
    private val apiService: ApiService,
    private val db: CountryDatabase
) {

    private val countriesDAO = db.countriesDao()

    fun getAllCountries() = cacheResource(
        query = {
            countriesDAO.getAllCountries()
        },
        fetch = {
            delay(1000)
            apiService.getAllCountries()
        },

        saveFetchResult = { countries ->
                db.runInTransaction {
                    countriesDAO.deleteAllCountries()
                    countriesDAO.addCountries(countries.body())
                }
            }
        }
    )

}