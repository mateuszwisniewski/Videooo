package com.wisnia.videooo.splashscreen

import com.wisnia.videooo.mvp.BasePresenter
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor() : BasePresenter<SplashScreenView>() {

    override fun startPresenting() {
        view?.get()?.showLoginScreen()
    }
}