package com.bersyte.cacheapp.di

import android.app.Application
import androidx.room.Room
import com.bersyte.cacheapp.api.ApiService
import com.bersyte.cacheapp.db.CountryDatabase
import com.bersyte.cacheapp.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object CacheAppModule {

    @Provides
    @Singleton
    fun provideRetrofitInstance(): ApiService =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)


    @Provides
    @Singleton
    fun provideDatabase(app: Application): CountryDatabase =
        Room.databaseBuilder(
            app,
            CountryDatabase::class.java,
            "countries_db"
        )
            .build()


}