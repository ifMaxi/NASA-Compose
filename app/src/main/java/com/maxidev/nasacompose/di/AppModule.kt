package com.maxidev.nasacompose.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.maxidev.nasacompose.data.network.remote.ApiService
import com.maxidev.nasacompose.data.network.remote.TokenInterceptor
import com.maxidev.nasacompose.data.repository.NasaRepositoryImpl
import com.maxidev.nasacompose.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @[Provides Singleton]
    fun providesRetrofit(): Retrofit {
        val contentType = "application/json".toMediaType()
        val client = OkHttpClient.Builder()
            .addInterceptor(TokenInterceptor())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(client)
            .build()
    }

    @[Provides Singleton]
    fun providesApiService(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)

    @[Provides Singleton]
    fun providesRepository(apiService: ApiService): NasaRepositoryImpl =
        NasaRepositoryImpl(apiService)
}