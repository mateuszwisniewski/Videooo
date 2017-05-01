package com.wisnia.videooo.network

import com.wisnia.videooo.network.data.Timeout
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import rx.Observable

class OkHttpClientProvider(interceptors: List<Interceptor>, timeout: Timeout) {

    private val okHttpClient: OkHttpClient

    init {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        Observable.from(interceptors)
                .forEach { builder.addInterceptor(it) }
        builder.connectTimeout(timeout.time, timeout.unit)
        okHttpClient = builder.build()
    }

    fun getHttpClient(): OkHttpClient {
        return okHttpClient
    }
}
