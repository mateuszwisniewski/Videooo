package com.wisnia.videooo.dependency.components

import com.wisnia.videooo.ui.activity.SplashScreenActivity
import dagger.Component

@Component
interface SplashScreenComponent {

    fun inject(activity: SplashScreenActivity)
}