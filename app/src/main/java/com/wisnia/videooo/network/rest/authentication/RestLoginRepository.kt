package com.wisnia.videooo.network.rest.authentication

import com.wisnia.videooo.data.authentication.Token
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestLoginRepository {

    @GET("authentication/token/validate_with_login")
    fun signIn(@Query("username") username: String,
               @Query("password") password: String,
               @Query("request_token") requestToken: String): Single<Token>
}