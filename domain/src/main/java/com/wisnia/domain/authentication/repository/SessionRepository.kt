package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.GuestSessionModel
import com.wisnia.domain.authentication.model.SessionModel
import io.reactivex.Single

interface SessionRepository {

    fun session(requestToken: String): Single<SessionModel>

    val guestSession: Single<GuestSessionModel>
}