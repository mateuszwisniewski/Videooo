package com.wisnia.videooo.network

import retrofit2.Retrofit

class RetrofitServiceProvider(private val retrofit: Retrofit) : HttpServiceProvider {

    override fun <T> getService(serviceClass: Class<T>): T = retrofit.create(serviceClass)
}