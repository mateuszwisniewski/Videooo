package com.wisnia.data.authentication.repository.session

import com.wisnia.domain.authentication.model.GuestSessionModel
import com.wisnia.domain.authentication.model.SessionModel
import com.wisnia.domain.authentication.repository.SessionRepository
import io.reactivex.Single
import javax.inject.Inject

class SessionDataRepository @Inject constructor(private val httpSessionRepository: HttpSessionRepository) :
    SessionRepository {

    override fun session(requestToken: String): Single<SessionModel> =
        httpSessionRepository.session(requestToken)

    override val guestSession: Single<GuestSessionModel> = httpSessionRepository.guestSession
}
