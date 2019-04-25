package com.wisnia.videooo.splashscreen.viewmodel

import com.wisnia.videooo.common.viewmodel.LifecycleViewModel
import com.wisnia.videooo.splashscreen.navigator.SplashScreenEvent.NavigateToLoginScreen
import com.wisnia.videooo.splashscreen.navigator.SplashScreenNavigator
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    private val navigator: SplashScreenNavigator
) : LifecycleViewModel() {

    override fun onInitialize() {
        super.onInitialize()
        navigateToLoginScreen()
    }

    private fun navigateToLoginScreen() {
        navigator.apply {
            subscribe()
            call(NavigateToLoginScreen)
        }
    }
}
