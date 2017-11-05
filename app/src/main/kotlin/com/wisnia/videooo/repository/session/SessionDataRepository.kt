package com.wisnia.videooo.repository.session

import com.wisnia.videooo.data.authentication.GuestSession
import com.wisnia.videooo.data.authentication.Session
import com.wisnia.videooo.repository.authentication.SessionRepository
import io.reactivex.Single
import javax.inject.Inject

class SessionDataRepository @Inject constructor(private val httpSessionRepository: HttpSessionRepository) : SessionRepository {

    override fun session(requestToken: String): Single<Session> =
            httpSessionRepository.session(requestToken)

    override val guestSession: Single<GuestSession>
        get() = httpSessionRepository.guestSession
}
