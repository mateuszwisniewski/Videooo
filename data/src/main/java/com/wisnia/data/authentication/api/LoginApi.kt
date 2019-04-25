package com.wisnia.data.authentication.api

import com.wisnia.domain.authentication.model.Token
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {

    @GET("authentication/token/validate_with_login")
    fun signIn(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("request_token") requestToken: String
    ): Deferred<Token>
}
