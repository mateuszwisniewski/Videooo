package com.wisnia.videooo.dependency.modules

import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.repository.ApiTokenRepository
import com.wisnia.videooo.repository.authentication.TokenRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RestRepositoryModule {

    @Provides
    @Singleton
    fun provideTokenRepository(httpServiceProvider: HttpServiceProvider): TokenRepository {
        return ApiTokenRepository(httpServiceProvider)
    }
}