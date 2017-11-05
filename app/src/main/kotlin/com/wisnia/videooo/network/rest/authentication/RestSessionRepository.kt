package com.wisnia.videooo.network.rest.authentication

import com.wisnia.videooo.data.authentication.GuestSession
import com.wisnia.videooo.data.authentication.Session
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestSessionRepository {

    @GET("authentication/session/new")
    fun session(@Query("request_token") requestToken: String): Single<Session>

    @get:GET("authentication/guest_session/new")
    val guestSession: Single<GuestSession>
}
