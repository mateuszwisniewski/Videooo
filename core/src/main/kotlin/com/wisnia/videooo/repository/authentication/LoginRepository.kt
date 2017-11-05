package com.wisnia.videooo.repository.authentication

import com.wisnia.videooo.data.authentication.GuestSession
import com.wisnia.videooo.data.authentication.Session
import io.reactivex.Single

interface LoginRepository {

    fun signIn(username: String, password: String): Single<Session>

    val signInAsGuest: Single<GuestSession>
}
