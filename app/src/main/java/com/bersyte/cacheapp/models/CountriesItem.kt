package com.bersyte.cacheapp.models


data class CountriesItem(
    val altSpellings: List<String>,
    val area: Double,
    val callingCodes: List<String>,
    val capital: String,
    val cioc: String,
    val demonym: String,
    val flag: String,
    val latlng: List<Double>,
    val name: String,
    val nativeName: String,
    val numericCode: String,
    val population: Int
)