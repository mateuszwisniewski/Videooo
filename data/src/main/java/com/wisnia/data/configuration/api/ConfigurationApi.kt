package com.wisnia.data.configuration.api

import com.wisnia.data.configuration.model.Configuration
import io.reactivex.Single
import retrofit2.http.GET

interface ConfigurationApi {

    @get:GET("configuration")
    val configuration: Single<Configuration>
}