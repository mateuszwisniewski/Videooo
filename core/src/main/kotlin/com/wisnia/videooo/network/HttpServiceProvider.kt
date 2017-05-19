package com.wisnia.videooo.network

interface HttpServiceProvider {

    fun <T> getService(serviceClass: Class<T>): T
}
