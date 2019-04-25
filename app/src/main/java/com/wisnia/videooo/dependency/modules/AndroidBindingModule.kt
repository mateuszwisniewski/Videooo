package com.wisnia.videooo.dependency.modules

import com.wisnia.videooo.login.LoginActivity
import com.wisnia.videooo.splashscreen.view.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashScreenActivity(): SplashScreenActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}
