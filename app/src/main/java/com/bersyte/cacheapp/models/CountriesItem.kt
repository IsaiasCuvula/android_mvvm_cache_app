package com.bersyte.cacheapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountriesItem(
    val callingCodes: List<String>,
    val capital: String,
    val flag: String,
    @PrimaryKey val name: String,
    val population: Int
)