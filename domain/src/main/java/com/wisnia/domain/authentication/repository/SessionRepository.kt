package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Session
import kotlinx.coroutines.Deferred

interface SessionRepository {

    suspend fun session(requestToken: String): Session

    fun guestSession(): Deferred<GuestSession>
}