package com.wisnia.data.authentication.api

import com.wisnia.data.authentication.model.Token
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface LoginApi {

    @GET("authentication/token/validate_with_login")
    fun signIn(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("request_token") requestToken: String
    ): Single<Token>
}
