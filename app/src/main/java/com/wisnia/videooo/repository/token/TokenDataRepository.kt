package com.wisnia.videooo.repository.token

import com.wisnia.domain.authentication.model.Token
import com.wisnia.domain.authentication.repository.TokenRepository
import javax.inject.Inject

class TokenDataRepository @Inject constructor(private val httpTokenRepository: HttpTokenRepository) :
    TokenRepository {

    override suspend fun token(): Token = httpTokenRepository.token()
}
