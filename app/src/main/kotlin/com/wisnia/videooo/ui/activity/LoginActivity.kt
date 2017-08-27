package com.wisnia.videooo.ui.activity

import android.os.Bundle
import com.wisnia.videooo.R
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.presenter.LoginPresenter
import com.wisnia.videooo.ui.PresentationActivity
import com.wisnia.videooo.view.LoginView
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.layout_login_form.*
import javax.inject.Inject

class LoginActivity : PresentationActivity<LoginView>(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun getPresenter(): Presenter<LoginView> = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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