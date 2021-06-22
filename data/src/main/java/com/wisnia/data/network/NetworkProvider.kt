package com.wisnia.data.network

import android.content.Context
import com.wisnia.data.BuildConfig
import com.wisnia.data.network.RetrofitProvider.provideRetrofit
import com.wisnia.data.network.interceptor.ApiKeyInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit

private const val CACHE_SIZE: Long = 10 * 1024 * 1024

class NetworkProvider(private val context: Context) {

    fun provideApiKeyRetrofit(): Retrofit =
        provideRetrofit(
            provideOkHttpClientBuilder()
                .addInterceptor(ApiKeyInterceptor(BuildConfig.TMDB_API_KEY))
                .build()
        )

    private fun provideOkHttpClientBuilder(): OkHttpClient.Builder =
        OkHttpClient.Builder()
            .cache(Cache(context.cacheDir, CACHE_SIZE))
}
