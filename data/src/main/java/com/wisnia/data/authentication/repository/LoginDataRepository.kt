package com.wisnia.data.authentication.repository

import com.wisnia.data.authentication.api.LoginApi
import com.wisnia.domain.authentication.model.GuestSession
import com.wisnia.domain.authentication.model.Token
import com.wisnia.domain.authentication.repository.LoginRepository

class LoginDataRepository(private val loginApi: LoginApi) : LoginRepository {

    override suspend fun signIn(username: String, password: String, token: String): Token =
        loginApi.signIn(username, password, token).await()

    override suspend fun signInAsGuest(): GuestSession = TODO("not implemented")
}
