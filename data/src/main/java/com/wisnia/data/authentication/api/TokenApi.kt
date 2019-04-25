package com.wisnia.data.authentication.api

import com.wisnia.domain.authentication.model.Token
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface TokenApi {

    @get:GET("authentication/token/new")
    val token: Deferred<Response<Token>>
}
