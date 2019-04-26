package com.wisnia.videooo.application.di

import android.app.Application
import com.wisnia.videooo.application.VideoooApplication
import com.wisnia.videooo.login.di.LoginBinder
import com.wisnia.videooo.main.di.MainBinder
import com.wisnia.videooo.splashscreen.di.SplashScreenBinder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        SplashScreenBinder::class,
        LoginBinder::class,
        MainBinder::class
    ]
)
interface ApplicationComponent : AndroidInjector<VideoooApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(application: VideoooApplication)
}
