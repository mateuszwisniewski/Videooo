package com.wisnia.videooo.dependency.modules

import com.wisnia.domain.authentication.repository.LoginRepository
import com.wisnia.domain.authentication.repository.SessionRepository
import com.wisnia.domain.authentication.repository.TokenRepository
import com.wisnia.videooo.repository.login.LoginDataRepository
import com.wisnia.videooo.repository.session.HttpSessionRepository
import com.wisnia.videooo.repository.session.SessionDataRepository
import com.wisnia.videooo.repository.token.HttpTokenRepository
import com.wisnia.videooo.repository.token.TokenDataRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiRepositoryModule {

    @Provides
    @Singleton
    fun provideTokenDataRepository(httpTokenRepository: HttpTokenRepository): TokenRepository =
        TokenDataRepository(httpTokenRepository)

    @Provides
    @Singleton
    fun provideLoginDataRepository(): LoginRepository = LoginDataRepository()

    @Provides
    @Singleton
    fun provideSessionDataRepository(httpSessionRepository: HttpSessionRepository): SessionRepository =
        SessionDataRepository(httpSessionRepository)
}
