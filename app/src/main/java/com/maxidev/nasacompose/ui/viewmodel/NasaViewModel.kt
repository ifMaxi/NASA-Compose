package com.maxidev.nasacompose.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maxidev.nasacompose.data.network.ApiResponse
import com.maxidev.nasacompose.data.repository.NasaRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class NasaViewModel @Inject constructor(
    private val repositoryImpl: NasaRepositoryImpl
): ViewModel() {
    var apod: ApiResponse by mutableStateOf(ApiResponse.Loading)
        private set

    init {
        getApod()
    }

    private fun getApod() {
        viewModelScope.launch {
            apod = ApiResponse.Loading
            apod = try {
                ApiResponse.Success(repositoryImpl.apodMethod())
            } catch (e: IOException) {
                ApiResponse.Error(e)
            } catch (e: HttpException) {
                ApiResponse.Error(e)
            }
        }
    }
}