package com.wisnia.videooo.ui.activity

import android.content.Intent
import android.os.Bundle
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.presenter.SplashScreenPresenter
import com.wisnia.videooo.ui.PresentationActivity
import com.wisnia.videooo.view.SplashScreenView
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashScreenActivity : PresentationActivity<SplashScreenView>(), SplashScreenView {
    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun getPresenter(): Presenter<SplashScreenView> = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun showLoginScreen() {
        Intent(this, LoginActivity::class.java).let {
            startActivity(it)
            finish()
        }
    }
}
