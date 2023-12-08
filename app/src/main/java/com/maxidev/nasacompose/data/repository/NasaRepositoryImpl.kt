package com.maxidev.nasacompose.data.repository

import com.maxidev.nasacompose.data.model.apodmodel.ApodModel
import com.maxidev.nasacompose.data.network.remote.ApiService
import javax.inject.Inject

class NasaRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): NasaRepository {
    override suspend fun apodMethod(): ApodModel =
        apiService.getApod()
}