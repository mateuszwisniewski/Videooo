package com.wisnia.data.authentication.repository.token

import com.wisnia.data.authentication.api.TokenApi
import com.wisnia.domain.authentication.model.Token
import io.reactivex.Single
import javax.inject.Inject

class HttpTokenRepository @Inject constructor(
    private val tokenApi: TokenApi,
    private val extractor: AuthenticationHeaderInterceptor
) {

    val token: Single<Token>
        get() = tokenApi.token
            .flatMap { extractor.intercept(it) }
}
