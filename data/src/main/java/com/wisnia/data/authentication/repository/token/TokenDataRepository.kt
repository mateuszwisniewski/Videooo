package com.wisnia.data.authentication.repository.token

import com.wisnia.domain.authentication.model.TokenModel
import com.wisnia.domain.authentication.repository.TokenRepository
import io.reactivex.Single
import javax.inject.Inject

class TokenDataRepository @Inject constructor(private val httpTokenRepository: HttpTokenRepository) :
    TokenRepository {

    override val token: Single<TokenModel>
        get() = httpTokenRepository.token
}
