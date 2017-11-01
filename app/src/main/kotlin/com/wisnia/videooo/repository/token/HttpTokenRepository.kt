package com.wisnia.videooo.repository.token

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.rest.authentication.RestTokenRepository
import io.reactivex.Single
import javax.inject.Inject

class HttpTokenRepository @Inject constructor(serviceProvider: HttpServiceProvider) {
    private val tokenRepository = serviceProvider.getService(RestTokenRepository::class.java)
    private val authenticationHeaderKey = "Authentication-Callback"

    val token: Single<Token>
        get() = tokenRepository.token.flatMap {
            val authenticationHeader = it.headers().get(authenticationHeaderKey)
            val token = it.body()
            token?.authenticationPage = authenticationHeader
            Single.just(token)
        }
}