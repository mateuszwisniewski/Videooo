package com.wisnia.videooo.application.di

import android.app.Application
import android.content.Context
import com.wisnia.data.network.NetworkProvider
import com.wisnia.videooo.common.scheduler.RxScheduler
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideScheduler(): RxScheduler = RxScheduler()

    @Singleton
    @Provides
    fun provideCommonApiRetrofit(networkProvider: NetworkProvider): Retrofit =
        networkProvider.provideApiKeyRetrofit()

    @Singleton
    @Provides
    fun provideNetworkProvider(context: Context): NetworkProvider = NetworkProvider(context)
}
