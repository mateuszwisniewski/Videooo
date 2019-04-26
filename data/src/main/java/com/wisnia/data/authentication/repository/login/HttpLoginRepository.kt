package com.wisnia.data.authentication.repository.login

import com.wisnia.data.authentication.api.LoginApi
import com.wisnia.data.authentication.model.toDomain
import com.wisnia.domain.authentication.model.TokenModel
import io.reactivex.Single
import javax.inject.Inject

class HttpLoginRepository @Inject constructor(private val loginApi: LoginApi) {

    fun signIn(username: String, password: String, requestToken: String): Single<TokenModel> =
        loginApi.signIn(username, password, requestToken)
            .map { token -> token.toDomain() }
}