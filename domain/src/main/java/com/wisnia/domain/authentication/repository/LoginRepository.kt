package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Session
import io.reactivex.Single

interface LoginRepository {

    fun signIn(username: String, password: String): Single<Session>

    val signInAsGuest: Single<GuestSession>
}
