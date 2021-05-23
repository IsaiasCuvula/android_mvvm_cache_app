package com.bersyte.cacheapp.models


data class CountriesItem(
    val callingCodes: List<String>,
    val capital: String,
    val flag: String,
    val name: String,
    val population: Int
)