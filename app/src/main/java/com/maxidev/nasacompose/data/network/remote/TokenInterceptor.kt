package com.maxidev.nasacompose.data.network.remote

import com.maxidev.nasacompose.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor: Interceptor {
    private val apiKey = BuildConfig.API_KEY

    override fun intercept(chain: Interceptor.Chain): Response {
        var original = chain.request()
        val url = original.url
            .newBuilder()
            .addQueryParameter("api_key", apiKey)
            .build()

        original = original
            .newBuilder()
            .url(url)
            .build()

        return chain.proceed(original)
    }
}