package com.wisnia.videooo.repository.authentication

import com.wisnia.videooo.data.authentication.Token
import io.reactivex.Observable

interface TokenRepository {

    val token: Observable<Token>
}
