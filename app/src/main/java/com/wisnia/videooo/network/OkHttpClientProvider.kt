package com.wisnia.videooo.network

import com.wisnia.videooo.network.data.Timeout
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient

class OkHttpClientProvider(private val interceptors: List<Interceptor>,
                           private val timeout: Timeout) {

    val okHttpClient: OkHttpClient
        get() {
            return OkHttpClient.Builder().let {
                Observable.fromIterable(interceptors)
                        .forEach { interceptor -> it.addInterceptor(interceptor) }
                it.connectTimeout(timeout.time, timeout.unit)
                it.build()
            }
        }
}
