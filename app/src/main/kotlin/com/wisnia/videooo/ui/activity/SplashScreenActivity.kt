package com.wisnia.videooo.ui.activity

import android.content.Intent
import android.os.Bundle
import com.wisnia.videooo.dependency.components.DaggerSplashScreenComponent
import com.wisnia.videooo.dependency.components.SplashScreenComponent
import com.wisnia.videooo.mvp.View
import com.wisnia.videooo.presenter.SplashScreenPresenter
import com.wisnia.videooo.ui.PresentationActivity
import com.wisnia.videooo.view.SplashScreenView
import javax.inject.Inject

class SplashScreenActivity : PresentationActivity<View, SplashScreenComponent>(), SplashScreenView {

    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun onBuildComponent(): SplashScreenComponent {
        return DaggerSplashScreenComponent.create().apply {
            inject(this@SplashScreenActivity)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setPresenter(presenter, this)
    }

    override fun showLoginScreen() {
        Intent(this, LoginActivity::class.java).let {
            startActivity(it)
            finish()
        }
    }
}