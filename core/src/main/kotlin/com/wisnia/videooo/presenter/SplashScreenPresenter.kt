package com.wisnia.videooo.presenter

import com.wisnia.videooo.mvp.BasePresenter
import com.wisnia.videooo.view.SplashScreenView
import javax.inject.Inject

class SplashScreenPresenter @Inject constructor() : BasePresenter<SplashScreenView>() {

    override fun startPresenting() {
        view?.get()?.showLoginScreen()
    }
}