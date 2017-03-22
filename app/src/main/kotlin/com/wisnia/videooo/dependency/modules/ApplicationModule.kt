package com.wisnia.videooo.dependency.modules

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(val application: Application) {

    @Singleton
    @Provides
    internal fun provideApplication(): Application {
        return application
    }
}