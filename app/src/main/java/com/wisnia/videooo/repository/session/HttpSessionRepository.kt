package com.wisnia.videooo.repository.session

import com.wisnia.videooo.data.authentication.Session
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.rest.authentication.RestSessionRepository
import io.reactivex.Single
import javax.inject.Inject

class HttpSessionRepository @Inject constructor(serviceProvider: HttpServiceProvider) {

    private val sessionRepository = serviceProvider.getService(RestSessionRepository::class.java)

    fun session(requestToken: String): Single<Session> = sessionRepository.session(requestToken)

    val guestSession = sessionRepository.guestSession
}