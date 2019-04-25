package com.wisnia.videooo.splashscreen

import android.content.Intent
import android.os.Bundle
import com.wisnia.videooo.login.LoginActivity
import com.wisnia.videooo.mvp.PresentationActivity
import com.wisnia.videooo.mvp.Presenter
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
