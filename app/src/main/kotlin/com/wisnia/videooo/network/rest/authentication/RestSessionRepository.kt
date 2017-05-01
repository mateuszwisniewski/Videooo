package com.wisnia.videooo.network.rest.authentication

import com.wisnia.videooo.data.authentication.Session
import io.reactivex.Observable
import retrofit2.http.GET

interface RestSessionRepository {

    @get:GET("/authentication/session/new")
    val session: Observable<Session>
}