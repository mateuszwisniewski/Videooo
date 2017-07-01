package com.wisnia.videooo.ui.activity

import android.content.Intent
import com.wisnia.videooo.dependency.components.DaggerSplashScreenComponent
import com.wisnia.videooo.dependency.components.SplashScreenComponent
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.presenter.SplashScreenPresenter
import com.wisnia.videooo.ui.PresentationActivity
import com.wisnia.videooo.view.SplashScreenView
import javax.inject.Inject

class SplashScreenActivity : PresentationActivity<SplashScreenView, SplashScreenComponent>(), SplashScreenView {
    @Inject
    lateinit var presenter: SplashScreenPresenter

    override fun getPresenter(): Presenter<SplashScreenView> {
        return presenter
    }

    override fun onBuildComponent(): SplashScreenComponent {
        return DaggerSplashScreenComponent.create().apply {
            inject(this@SplashScreenActivity)
        }
    }

    override fun showLoginScreen() {
        Intent(this, LoginActivity::class.java).let {
            startActivity(it)
            finish()
        }
    }
}