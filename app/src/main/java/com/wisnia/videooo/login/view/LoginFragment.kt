package com.wisnia.videooo.login.view

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wisnia.videooo.R
import com.wisnia.videooo.common.di.ViewModelFactory
import com.wisnia.videooo.common.extensions.bindViewData
import com.wisnia.videooo.common.extensions.viewModel
import com.wisnia.videooo.databinding.FragmentLoginBinding
import com.wisnia.videooo.login.navigation.WEB_AUTH_REQUEST_CODE
import com.wisnia.videooo.login.viewmodel.LoginViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

const val TOKEN_KEY = "token"

class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<LoginViewModel>

    private val loginViewModel by lazy<LoginViewModel> { viewModel(viewModelFactory) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        lifecycle.addObserver(loginViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = bindViewData<FragmentLoginBinding>(R.layout.fragment_login, container).also {
        it.viewModel = loginViewModel
    }.root

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
