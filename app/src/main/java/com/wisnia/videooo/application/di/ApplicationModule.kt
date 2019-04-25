package com.wisnia.videooo.application.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun provideMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
