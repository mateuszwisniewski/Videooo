package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.GuestSessionModel
import com.wisnia.domain.authentication.model.SessionModel
import io.reactivex.Single

interface LoginRepository {

    fun signIn(username: String, password: String): Single<SessionModel>

    val signInAsGuest: Single<GuestSessionModel>
}
