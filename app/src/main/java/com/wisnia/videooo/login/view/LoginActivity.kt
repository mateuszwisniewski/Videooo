package com.wisnia.videooo.login.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisnia.videooo.R
import com.wisnia.videooo.common.di.ViewModelFactory
import com.wisnia.videooo.common.extensions.bindViewData
import com.wisnia.videooo.common.extensions.viewModel
import com.wisnia.videooo.databinding.ActivityLoginBinding
import com.wisnia.videooo.login.navigation.WEB_AUTH_REQUEST_CODE
import com.wisnia.videooo.login.viewmodel.LoginViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == WEB_AUTH_REQUEST_CODE) handleWebsiteAuthenticationResult(resultCode)
    }

    private fun handleWebsiteAuthenticationResult(resultCode: Int) {
        when (resultCode) {
            Activity.RESULT_OK -> loginViewModel.onPermissionGranted()
            Activity.RESULT_CANCELED -> loginViewModel.onPermissionDenied()
        }
    }
}
