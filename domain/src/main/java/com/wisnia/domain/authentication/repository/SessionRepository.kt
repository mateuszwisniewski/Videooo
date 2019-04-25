package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Session
import io.reactivex.Single

interface SessionRepository {

    fun session(requestToken: String): Single<Session>

    val guestSession: Single<GuestSession>
}