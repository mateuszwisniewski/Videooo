package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Token

interface LoginRepository {

    suspend fun signIn(username: String, password: String, token: String): Token

    suspend fun signInAsGuest(): GuestSession
}
