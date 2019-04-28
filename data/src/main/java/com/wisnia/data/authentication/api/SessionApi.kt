package com.wisnia.data.authentication.api

import com.wisnia.data.authentication.model.GuestSessionEntity
import com.wisnia.data.authentication.model.SessionEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SessionApi {

    @GET("authentication/session/new")
    fun session(@Query("request_token") requestToken: String): Single<SessionEntity>

    @get:GET("authentication/guest_session/new")
    val guestSession: Single<GuestSessionEntity>
}
