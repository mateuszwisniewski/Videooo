package com.wisnia.domain.authentication.repository

import com.wisnia.domain.authentication.model.Token

interface TokenRepository {

    suspend fun token(): Token
}
