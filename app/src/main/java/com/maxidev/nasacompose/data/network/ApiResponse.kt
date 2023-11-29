package com.maxidev.nasacompose.data.network

interface ApiResponse {
    data class Success(val data: Any): ApiResponse
    data class Error(val exception: Exception): ApiResponse
    data object Loading: ApiResponse
}