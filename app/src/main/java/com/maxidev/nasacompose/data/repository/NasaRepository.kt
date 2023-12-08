package com.maxidev.nasacompose.data.repository

import com.maxidev.nasacompose.data.model.apodmodel.ApodModel

interface NasaRepository {
    suspend fun apodMethod(): ApodModel
}