package com.wisnia.videooo.splashscreen.di

import com.wisnia.videooo.application.di.scope.Activity
import com.wisnia.videooo.splashscreen.navigator.SplashScreenNavigator
import com.wisnia.videooo.splashscreen.view.SplashScreenActivity
import dagger.Module
import dagger.Provides

@Module
class SplashScreenModule {

    @Provides
    @Activity
    fun provideSplashScreenNavigator(activity: SplashScreenActivity): SplashScreenNavigator =
        SplashScreenNavigator(activity)
}
