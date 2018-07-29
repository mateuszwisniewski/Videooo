package com.wisnia.videooo.login

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.AuthenticationActivity
import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.databinding.ActivityLoginBinding
import com.wisnia.videooo.login.presentation.LoginType
import com.wisnia.videooo.login.presentation.LoginViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

private const val WEB_AUTH_REQUEST_CODE = 101
const val TOKEN_KEY = "token"

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        ViewModelProviders.of(this, viewModelFactory)[LoginViewModel::class.java].let {
            bindView(it)
            handleLoginType(it)
        }
    }

    private fun bindView(loginViewModel: LoginViewModel) {
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = loginViewModel
        binding.setLifecycleOwner(this)
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
