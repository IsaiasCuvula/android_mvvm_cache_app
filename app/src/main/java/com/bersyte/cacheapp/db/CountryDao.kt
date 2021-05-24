package com.bersyte.cacheapp.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bersyte.cacheapp.models.CountriesItem
import kotlinx.coroutines.flow.Flow

@Dao
interface CountryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCountries(countries: List<CountriesItem>)

    @Query("DELETE FROM countries")
    suspend fun deleteAllCountries()

    @Query("SELECT * FROM countries")
    fun getAllCountries(): Flow<List<CountriesItem>>

}