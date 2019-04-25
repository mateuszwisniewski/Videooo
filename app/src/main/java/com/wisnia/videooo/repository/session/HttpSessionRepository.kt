package com.wisnia.videooo.repository.session

import com.wisnia.data.authentication.api.SessionApi
import com.wisnia.domain.authentication.model.Session
import com.wisnia.videooo.network.HttpServiceProvider
import javax.inject.Inject

class HttpSessionRepository @Inject constructor(serviceProvider: HttpServiceProvider) {

    private val sessionRepository = serviceProvider.getService(SessionApi::class.java)

    suspend fun session(requestToken: String): Session =
        sessionRepository.session(requestToken).await()

    suspend fun guestSession() = sessionRepository.guestSession.await()
}