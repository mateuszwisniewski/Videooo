package com.wisnia.videooo.dependency.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application {
        return application
    }

    @Singleton
    @Provides
    fun provideMainThreadScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }
}
