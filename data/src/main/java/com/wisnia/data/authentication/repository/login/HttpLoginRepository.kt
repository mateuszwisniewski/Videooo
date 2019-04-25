package com.wisnia.data.authentication.repository.login

import com.wisnia.data.authentication.api.LoginApi
import com.wisnia.domain.authentication.model.Token
import io.reactivex.Single
import javax.inject.Inject

class HttpLoginRepository @Inject constructor(private val loginApi: LoginApi) {

    fun signIn(username: String, password: String, requestToken: String): Single<Token> =
        loginApi.signIn(username, password, requestToken)
}