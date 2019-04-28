package com.wisnia.data.configuration.api

import com.wisnia.data.configuration.model.ConfigurationEntity
import io.reactivex.Single
import retrofit2.http.GET

interface ConfigurationApi {

    @GET("configuration")
    fun configuration(): Single<ConfigurationEntity>
}