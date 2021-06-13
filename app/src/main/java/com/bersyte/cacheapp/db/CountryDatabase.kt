package com.bersyte.cacheapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bersyte.cacheapp.models.CountriesItem

@Database(entities = [CountriesItem::class], version = 1, exportSchema = false)
abstract class CountryDatabase : RoomDatabase() {

    abstract fun countriesDao(): CountryDao

}