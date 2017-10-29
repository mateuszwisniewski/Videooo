package com.wisnia.videooo.repository.authentication

import com.wisnia.videooo.data.authentication.Token
import io.reactivex.Single

interface LoginRepository {

    fun signIn(username: String, password: String): Single<Token>
}