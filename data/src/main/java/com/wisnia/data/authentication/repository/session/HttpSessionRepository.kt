package com.wisnia.data.authentication.repository.session

import com.wisnia.data.authentication.api.SessionApi
import com.wisnia.data.authentication.model.toDomain
import com.wisnia.domain.authentication.model.GuestSessionModel
import com.wisnia.domain.authentication.model.SessionModel
import io.reactivex.Single
import javax.inject.Inject

class HttpSessionRepository @Inject constructor(private val sessionApi: SessionApi) {

    fun session(requestToken: String): Single<SessionModel> =
        sessionApi.session(requestToken).map { session -> session.toDomain() }

    val guestSession: Single<GuestSessionModel> =
        sessionApi.guestSession.map { guestSession -> guestSession.toDomain() }
}
