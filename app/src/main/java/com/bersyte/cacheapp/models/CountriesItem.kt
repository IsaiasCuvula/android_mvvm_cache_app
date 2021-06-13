package com.bersyte.cacheapp.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountriesItem(
    @Ignore var callingCodes: List<String>,
    @Ignore var capital: String,
    @Ignore var flag: String,
    @Ignore var name: String,
    @PrimaryKey var population: Int,
) {
    constructor() : this(
        arrayListOf(), "", "", "",
        0
    )

}