package com.wisnia.data.authentication.repository.token

import com.wisnia.data.authentication.api.TokenApi
import com.wisnia.data.authentication.model.toDomain
import com.wisnia.domain.authentication.model.TokenModel
import io.reactivex.Single
import javax.inject.Inject

class HttpTokenRepository @Inject constructor(
    private val tokenApi: TokenApi,
    private val extractor: AuthenticationHeaderInterceptor
) {

    val token: Single<TokenModel>
        get() = tokenApi.token
            .flatMap { extractor.intercept(it) }
            .map { it.toDomain() }
}
