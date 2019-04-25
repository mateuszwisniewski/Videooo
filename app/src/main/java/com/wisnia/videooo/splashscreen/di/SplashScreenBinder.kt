package com.wisnia.videooo.splashscreen.di

import com.wisnia.videooo.application.di.scope.Activity
import com.wisnia.videooo.splashscreen.view.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashScreenBinder {

    @ContributesAndroidInjector(modules = [SplashScreenModule::class])
    @Activity
    abstract fun bindSplashScreenActivity(): SplashScreenActivity
}
