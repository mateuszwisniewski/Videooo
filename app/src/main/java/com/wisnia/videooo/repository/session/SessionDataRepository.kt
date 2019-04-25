package com.wisnia.videooo.repository.session

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Session
import com.wisnia.domain.authentication.repository.SessionRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject

class SessionDataRepository @Inject constructor(private val httpSessionRepository: HttpSessionRepository) :
    SessionRepository {

    override suspend fun session(requestToken: String): Session =
        httpSessionRepository.session(requestToken)

    override fun guestSession(): Deferred<GuestSession> {
        TODO("not implemented")
    }
}
