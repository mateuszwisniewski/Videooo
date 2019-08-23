package com.wisnia.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wisnia.data.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitProvider {

    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        provideRetrofit(BuildConfig.api_url, okHttpClient)

    fun provideRetrofit(
        url: String,
        okHttpClient: OkHttpClient
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(provideMoshiConverterFactory())
            .build()

    private fun provideMoshiConverterFactory(): MoshiConverterFactory =
        MoshiConverterFactory.create(provideMoshi())

    private fun provideMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
}
