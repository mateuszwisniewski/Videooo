package com.wisnia.videooo.network.rest.authentication

import com.wisnia.videooo.data.authentication.Token
import retrofit2.http.GET

interface RestTokenRepository {

    @get:GET("/authentication/token/new")
    val token: io.reactivex.Observable<Token>
}