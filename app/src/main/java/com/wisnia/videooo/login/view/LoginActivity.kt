package com.wisnia.videooo.login.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.AuthenticationActivity
import com.wisnia.videooo.common.di.ViewModelFactory
import com.wisnia.videooo.common.extensions.bindViewData
import com.wisnia.videooo.common.extensions.viewModel
import com.wisnia.videooo.databinding.ActivityLoginBinding
import com.wisnia.videooo.login.presentation.LoginType
import com.wisnia.videooo.login.viewmodel.LoginViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

private const val WEB_AUTH_REQUEST_CODE = 101
const val TOKEN_KEY = "token"

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<LoginViewModel>

    private val loginViewModel by lazy<LoginViewModel> { viewModel(viewModelFactory) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        bindViewData()
    }

    private fun bindViewData() {
        bindViewData<ActivityLoginBinding>(R.layout.activity_login).also {
            it.viewModel = loginViewModel
        }
    }

    private fun handleLoginType(loginViewModel: LoginViewModel) {
        loginViewModel.loginType.observe(this, Observer {
            when (it) {
                LoginType.SignIn -> {
                }
                is LoginType.SignInWeb -> showAuthenticationScreen(it.token)
                LoginType.Guest -> {
                }
            }
        })
    }

    private fun showAuthenticationScreen(token: Token) {
        val intent = Intent(this, AuthenticationActivity::class.java)
        intent.putExtra(TOKEN_KEY, token)
        startActivityForResult(intent, WEB_AUTH_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == WEB_AUTH_REQUEST_CODE) handleWebsiteAuthenticationResult(resultCode)
    }

    private fun handleWebsiteAuthenticationResult(resultCode: Int) {
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
