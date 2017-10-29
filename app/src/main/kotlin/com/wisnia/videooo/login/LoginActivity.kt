package com.wisnia.videooo.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.AuthenticationActivity
import com.wisnia.videooo.authentication.presentation.LoginPresenter
import com.wisnia.videooo.authentication.view.LoginView
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.extension.text
import com.wisnia.videooo.mvp.PresentationActivity
import com.wisnia.videooo.mvp.Presenter
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.layout_login_form.*
import javax.inject.Inject

private val authenticationRequestCode = 101
val tokenKey = "token"

class LoginActivity : PresentationActivity<LoginView>(), LoginView {

    @Inject
    lateinit var presenter: LoginPresenter

    override fun getPresenter(): Presenter<LoginView> = presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authSignInButton.setOnClickListener { signIn() }
        authSignInWebsiteButton.setOnClickListener { presenter.signInWebsite() }
        authRegisterButton.setOnClickListener { TODO("implement showing registration screen") }
        authGuestButton.setOnClickListener { presenter.signInAsGuest() }
    }

    private fun signIn() {
        val login = authLoginInput.text()
        val password = authPasswordInput.text()
        presenter.signIn(login, password)
    }

    override fun showError(error: Throwable) {
        // TODO: show response error
    }

    override fun onSignedIn(token: Token) {
        // TODO: show movies screen
    }

    override fun onSignedInWebsite(token: Token) {
        val intent = Intent(this, AuthenticationActivity::class.java)
        intent.putExtra(tokenKey, token)
        startActivityForResult(intent, authenticationRequestCode)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == authenticationRequestCode) handleAuthenticationResult(resultCode)
    }

    private fun handleAuthenticationResult(resultCode: Int) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                // TODO: show movies screen
                Log.d("LoginActivity", "Authentication success: User permission allowed")
            }
            Activity.RESULT_CANCELED -> {
                // TODO: show authentication error
                Log.d("LoginActivity", "Authentication failed: User permission denied")
            }
        }
    }
}