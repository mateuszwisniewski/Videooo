package com.wisnia.videooo.repository.login

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.repository.authentication.LoginRepository
import com.wisnia.videooo.repository.token.HttpTokenRepository
import io.reactivex.Single
import javax.inject.Inject

class LoginDataRepository @Inject constructor(private val httpLoginRepository: HttpLoginRepository,
                                              private val httpTokenRepository: HttpTokenRepository) : LoginRepository {

    override fun signIn(username: String, password: String): Single<Token> {
        return httpTokenRepository.token
                .flatMap { httpLoginRepository.signIn(username, password, it.token) }
    }
}