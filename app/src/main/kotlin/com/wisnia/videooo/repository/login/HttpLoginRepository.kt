package com.wisnia.videooo.repository.login

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.rest.authentication.RestLoginRepository
import io.reactivex.Single
import javax.inject.Inject

class HttpLoginRepository @Inject constructor(serviceProvider: HttpServiceProvider) {

    private val loginRepository = serviceProvider.getService(RestLoginRepository::class.java)

    fun signIn(username: String, password: String, requestToken: String): Single<Token> =
            loginRepository.signIn(username, password, requestToken)
}