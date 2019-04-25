package com.wisnia.data.authentication.repository.session

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Session
import com.wisnia.domain.authentication.repository.SessionRepository
import io.reactivex.Single
import javax.inject.Inject

class SessionDataRepository @Inject constructor(private val httpSessionRepository: HttpSessionRepository) :
    SessionRepository {

    override fun session(requestToken: String): Single<Session> =
        httpSessionRepository.session(requestToken)

    override val guestSession: Single<GuestSession> = httpSessionRepository.guestSession
}
