package com.maxidev.nasacompose.data.network.remote

import com.maxidev.nasacompose.data.model.apodmodel.ApodModel
import com.maxidev.nasacompose.utils.Constants.PLANETARY_APOD
import retrofit2.http.GET

interface ApiService {
    @GET(PLANETARY_APOD)
    suspend fun getApod(): ApodModel
}