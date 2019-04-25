package com.wisnia.videooo.repository.token

import com.wisnia.data.authentication.api.TokenApi
import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.network.HttpServiceProvider
import javax.inject.Inject

class HttpTokenRepository @Inject constructor(
    serviceProvider: HttpServiceProvider,
    private val extractor: AuthenticationHeaderInterceptor
) {

    private val tokenRepository = serviceProvider.getService(TokenApi::class.java)

    suspend fun token(): Token = tokenRepository.token.await().body()!!
}
