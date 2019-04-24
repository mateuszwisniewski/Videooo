package com.wisnia.videooo.repository.login

import com.wisnia.videooo.data.authentication.GuestSession
import com.wisnia.videooo.data.authentication.Session
import com.wisnia.videooo.repository.authentication.LoginRepository
import com.wisnia.videooo.repository.session.HttpSessionRepository
import com.wisnia.videooo.repository.token.HttpTokenRepository
import io.reactivex.Single
import javax.inject.Inject

class LoginDataRepository @Inject constructor(
    private val httpLoginRepository: HttpLoginRepository,
    private val httpTokenRepository: HttpTokenRepository,
    private val httpSessionRepository: HttpSessionRepository
) : LoginRepository {

    override fun signIn(username: String, password: String): Single<Session> =
        httpTokenRepository.token
            .flatMap { httpLoginRepository.signIn(username, password, it.token) }
            .flatMap { httpSessionRepository.session(it.token) }

    override val signInAsGuest: Single<GuestSession>
        get() = httpSessionRepository.guestSession
}
