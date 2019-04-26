package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.TokenModel
import io.reactivex.Single

interface TokenRepository {

    val token: Single<TokenModel>
}
