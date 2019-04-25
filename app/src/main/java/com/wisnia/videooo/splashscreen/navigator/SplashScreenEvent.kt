package com.wisnia.videooo.splashscreen.navigator

sealed class SplashScreenEvent {
    object NavigateToLoginScreen : SplashScreenEvent()
}