package com.bersyte.cacheapp.models

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "countries")
data class CountriesItem(
    @Ignore var callingCodes: List<String>,
    var capital: String,
    var flag: String,
    var name: String,
    @PrimaryKey var population: Int,
){
    constructor() : this(
        arrayListOf(),"", "", "",
        0
    )

}