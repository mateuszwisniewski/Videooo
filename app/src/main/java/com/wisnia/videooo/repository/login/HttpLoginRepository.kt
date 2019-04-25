package com.wisnia.videooo.repository.login

import com.wisnia.data.authentication.api.LoginApi
import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.network.HttpServiceProvider
import javax.inject.Inject

class HttpLoginRepository @Inject constructor(serviceProvider: HttpServiceProvider) {

    private val loginRepository = serviceProvider.getService(LoginApi::class.java)

    suspend fun signIn(username: String, password: String, requestToken: String): Token =
        loginRepository.signIn(username, password, requestToken).await()
}