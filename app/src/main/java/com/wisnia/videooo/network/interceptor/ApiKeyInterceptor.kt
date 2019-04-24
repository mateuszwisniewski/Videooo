package com.wisnia.videooo.network.interceptor

import okhttp3.Interceptor
import okhttp3.Response

private const val API_KEY_NAME: String = "api_key"

class ApiKeyInterceptor(private val apiKey: String) : Interceptor {
    init {
        if (apiKey.isEmpty()) {
            throw ApiKeyNotFoundException()
        }
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url()
                .newBuilder()
                .addQueryParameter(API_KEY_NAME, apiKey)
                .build()
        val parametrizedRequest = originalRequest.newBuilder()
                .url(url)
                .build()
        return chain.proceed(parametrizedRequest)
    }
}