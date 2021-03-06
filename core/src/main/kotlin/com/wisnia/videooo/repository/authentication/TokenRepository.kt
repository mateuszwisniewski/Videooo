package com.wisnia.videooo.repository.authentication

import com.wisnia.videooo.data.authentication.Token
import io.reactivex.Single

interface TokenRepository {

    val token: Single<Token>
}
