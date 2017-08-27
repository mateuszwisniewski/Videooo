package com.wisnia.videooo.dependency.modules

import com.wisnia.videooo.ui.activity.LoginActivity
import com.wisnia.videooo.ui.activity.SplashScreenActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AndroidBindingModule {

    @ContributesAndroidInjector
    abstract fun contributeSplashScreenActivity(): SplashScreenActivity

    @ContributesAndroidInjector
    abstract fun contributeLoginActivity(): LoginActivity
}
