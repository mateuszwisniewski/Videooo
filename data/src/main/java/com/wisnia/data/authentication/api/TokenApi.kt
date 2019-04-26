package com.wisnia.data.authentication.api

import com.wisnia.data.authentication.model.Token
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET

interface TokenApi {

    @get:GET("authentication/token/new")
    val token: Single<Response<Token>>
}
