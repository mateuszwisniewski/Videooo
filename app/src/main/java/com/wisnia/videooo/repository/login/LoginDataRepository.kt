package com.wisnia.videooo.repository.login

import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Token
import com.wisnia.domain.authentication.repository.LoginRepository
import javax.inject.Inject

class LoginDataRepository @Inject constructor() : LoginRepository {

    override suspend fun signIn(username: String, password: String, token: String): Token {
        TODO("not implemented")
    }

    override suspend fun signInAsGuest(): GuestSession {
        TODO("not implemented")
    }
}
