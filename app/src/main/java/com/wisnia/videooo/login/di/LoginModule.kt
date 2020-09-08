package com.wisnia.videooo.login.di

import com.wisnia.data.authentication.api.LoginApi
import com.wisnia.data.authentication.api.SessionApi
import com.wisnia.data.authentication.api.TokenApi
import com.wisnia.data.authentication.repository.login.HttpLoginRepository
import com.wisnia.data.authentication.repository.login.LoginDataRepository
import com.wisnia.data.authentication.repository.session.HttpSessionRepository
import com.wisnia.data.authentication.repository.session.SessionDataRepository
import com.wisnia.data.authentication.repository.token.HttpTokenRepository
import com.wisnia.data.authentication.repository.token.TokenDataRepository
import com.wisnia.domain.authentication.repository.LoginRepository
import com.wisnia.domain.authentication.repository.SessionRepository
import com.wisnia.domain.authentication.repository.TokenRepository
import com.wisnia.videooo.application.di.scope.Activity
import com.wisnia.videooo.login.navigation.LoginNavigator
import com.wisnia.videooo.login.view.LoginFragment
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class LoginModule {

    @Provides
    @Activity
    fun provideLoginNavigator(fragment: LoginFragment): LoginNavigator = LoginNavigator(fragment)

    @Provides
    @Activity
    fun provideTokenDataRepository(httpTokenRepository: HttpTokenRepository): TokenRepository =
        TokenDataRepository(httpTokenRepository)

    @Provides
    @Activity
    fun provideLoginDataRepository(
        httpLoginRepository: HttpLoginRepository,
        httpTokenRepository: HttpTokenRepository,
        httpSessionRepository: HttpSessionRepository
    ): LoginRepository =
        LoginDataRepository(httpLoginRepository, httpTokenRepository, httpSessionRepository)

    @Provides
    @Activity
    fun provideSessionDataRepository(httpSessionRepository: HttpSessionRepository): SessionRepository =
        SessionDataRepository(
            httpSessionRepository
        )

    @Provides
    @Activity
    fun provideTokenApi(retrofit: Retrofit): TokenApi = retrofit.create(TokenApi::class.java)

    @Provides
    @Activity
    fun provideLoginApi(retrofit: Retrofit): LoginApi = retrofit.create(LoginApi::class.java)

    @Provides
    @Activity
    fun provideSessionApi(retrofit: Retrofit): SessionApi = retrofit.create(SessionApi::class.java)
}
