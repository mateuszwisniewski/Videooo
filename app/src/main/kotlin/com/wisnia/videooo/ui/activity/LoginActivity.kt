package com.wisnia.videooo.ui.activity

import android.os.Bundle
import com.wisnia.videooo.R
import com.wisnia.videooo.VideoooApplication
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.dependency.components.DaggerLoginComponent
import com.wisnia.videooo.dependency.components.LoginComponent
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.presenter.LoginPresenter
import com.wisnia.videooo.ui.PresentationActivity
import com.wisnia.videooo.view.LoginView
import kotlinx.android.synthetic.main.layout_login_form.*
import javax.inject.Inject

class LoginActivity : PresentationActivity<LoginView, Any>(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun onBuildComponent(): LoginComponent {
        val loginComponent = DaggerLoginComponent.builder()
                .applicationComponent(VideoooApplication.appComponent)
                .build()
        loginComponent.inject(this)
        return loginComponent
    }

    override fun getPresenter(): Presenter<LoginView> {
        return presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authSignInButton.setOnClickListener { presenter.signIn() }
        authRegisterButton.setOnClickListener { TODO("implement showing registration screen") }
        authGuestButton.setOnClickListener { presenter.signInAsGuest() }
    }

    override fun showError(error: Throwable) {
    }

    override fun onTokenReceived(token: Token) {
        token.toString()
    }
}