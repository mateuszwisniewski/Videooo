package com.wisnia.videooo.dependency.modules

import android.app.Application
import com.wisnia.videooo.dependency.factory.ViewModelModule
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Singleton

@Module(includes = [(ViewModelModule::class)])
class ApplicationModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideApplication(): Application = application

    @Singleton
    @Provides
    fun provideMainThreadScheduler(): Scheduler = AndroidSchedulers.mainThread()
}
