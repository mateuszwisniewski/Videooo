package com.wisnia.videooo.network.rest.authentication

import com.wisnia.videooo.data.authentication.Token
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface RestTokenRepository {

    @get:GET("authentication/token/new")
    val token: Observable<Response<Token>>
}