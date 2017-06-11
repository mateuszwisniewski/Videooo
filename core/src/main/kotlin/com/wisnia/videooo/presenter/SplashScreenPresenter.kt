package com.wisnia.videooo.presenter

import com.wisnia.videooo.mvp.BasePresenter
import com.wisnia.videooo.view.SplashScreenView

class SplashScreenPresenter : BasePresenter<SplashScreenView>() {

    override fun startPresenting() {
        view?.showLoginScreen()
    }
}