package com.wisnia.videooo.login.navigation

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.wisnia.domain.authentication.model.TokenModel
import com.wisnia.videooo.R
import com.wisnia.videooo.authentication.view.AuthenticationActivity
import com.wisnia.videooo.common.navigator.Navigator
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToMovies
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToSignInWebsite
import com.wisnia.videooo.login.view.LoginFragment
import com.wisnia.videooo.login.view.TOKEN_KEY

const val WEB_AUTH_REQUEST_CODE = 101

class LoginNavigator(val fragment: LoginFragment) : Navigator<LoginEvent>(fragment) {

    override val navigationObserver: Observer<LoginEvent> = Observer {
        when (it) {
            is NavigateToSignInWebsite -> showAuthenticationScreen(it.token)
            is NavigateToMovies -> navigateToMoviesScreen()
        }
    }

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(fragment)
    }

    private fun showAuthenticationScreen(token: TokenModel) {
        val intent = Intent(fragment.context, AuthenticationActivity::class.java).apply {
            putExtra(TOKEN_KEY, token)
        }
        fragment.startActivityForResult(intent, WEB_AUTH_REQUEST_CODE)
    }

    private fun navigateToMoviesScreen() {
        navController.navigate(R.id.action_loginFragment_to_fragmentMovies)
    }
}
