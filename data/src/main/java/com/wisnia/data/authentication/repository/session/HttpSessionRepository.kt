package com.wisnia.data.authentication.repository.session

import com.wisnia.data.authentication.api.SessionApi
import com.wisnia.domain.authentication.model.Session
import io.reactivex.Single
import javax.inject.Inject

class HttpSessionRepository @Inject constructor(private val sessionApi: SessionApi) {

    fun session(requestToken: String): Single<Session> = sessionApi.session(requestToken)

    val guestSession = sessionApi.guestSession
}