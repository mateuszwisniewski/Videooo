package com.wisnia.videooo.dependency.modules

import com.wisnia.videooo.repository.authentication.LoginRepository
import com.wisnia.videooo.repository.authentication.TokenRepository
import com.wisnia.videooo.repository.login.HttpLoginRepository
import com.wisnia.videooo.repository.login.LoginDataRepository
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
    fun provideLoginDataRepository(httpLoginRepository: HttpLoginRepository,
                                   httpTokenRepository: HttpTokenRepository): LoginRepository =
            LoginDataRepository(httpLoginRepository, httpTokenRepository)
}