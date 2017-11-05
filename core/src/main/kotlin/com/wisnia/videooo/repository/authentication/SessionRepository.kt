package com.wisnia.videooo.repository.authentication

import com.wisnia.videooo.data.authentication.GuestSession
import com.wisnia.videooo.data.authentication.Session
import io.reactivex.Single

interface SessionRepository {

    fun session(requestToken: String): Single<Session>

    val guestSession: Single<GuestSession>
}