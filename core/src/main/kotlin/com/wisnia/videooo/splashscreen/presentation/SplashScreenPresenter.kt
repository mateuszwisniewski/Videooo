package com.wisnia.videooo.splashscreen.presentation

import com.wisnia.videooo.mvp.BasePresenter
import com.wisnia.videooo.splashscreen.view.SplashScreenView
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor() : BasePresenter<SplashScreenView>() {

    override fun startPresenting() {
        view?.get()?.showLoginScreen()
    }
}