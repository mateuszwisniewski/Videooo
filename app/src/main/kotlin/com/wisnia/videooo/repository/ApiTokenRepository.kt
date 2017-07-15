package com.wisnia.videooo.repository

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.rest.authentication.RestTokenRepository
import com.wisnia.videooo.repository.authentication.TokenRepository
import io.reactivex.Observable
import javax.inject.Inject

class ApiTokenRepository @Inject constructor(serviceProvider: HttpServiceProvider) : TokenRepository {
    val tokenRepository = serviceProvider.getService(RestTokenRepository::class.java)

    override val token: Observable<Token>
        get() = tokenRepository.token
}