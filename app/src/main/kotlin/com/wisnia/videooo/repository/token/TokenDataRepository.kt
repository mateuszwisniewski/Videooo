package com.wisnia.videooo.repository.token

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.repository.authentication.TokenRepository
import io.reactivex.Single
import javax.inject.Inject

class TokenDataRepository @Inject constructor(private val httpTokenRepository: HttpTokenRepository) : TokenRepository {

    override val token: Single<Token>
        get() = httpTokenRepository.token
}
