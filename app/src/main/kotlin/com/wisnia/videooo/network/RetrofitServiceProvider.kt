package com.wisnia.videooo.network

import retrofit2.Retrofit

class RetrofitServiceProvider(val retrofit: Retrofit) : HttpServiceProvider {

    override fun <T> getService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}