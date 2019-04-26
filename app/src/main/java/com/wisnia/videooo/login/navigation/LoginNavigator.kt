package com.wisnia.videooo.login.navigation

import android.content.Intent
import androidx.lifecycle.Observer
import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.authentication.view.AuthenticationActivity
import com.wisnia.videooo.common.navigator.Navigator
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToMovies
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToSignInWebsite
import com.wisnia.videooo.login.view.LoginActivity
import com.wisnia.videooo.login.view.TOKEN_KEY
import com.wisnia.videooo.main.view.MainActivity

const val WEB_AUTH_REQUEST_CODE = 101

class LoginNavigator(val activity: LoginActivity) : Navigator<LoginEvent>(activity) {

    override val navigationObserver: Observer<LoginEvent> = Observer {
        when (it) {
            is NavigateToSignInWebsite -> showAuthenticationScreen(it.token)
            is NavigateToMovies -> navigateToMoviesScreen()
        }
    }

    private fun showAuthenticationScreen(token: Token) {
        val intent = Intent(activity, AuthenticationActivity::class.java).apply {
            putExtra(TOKEN_KEY, token)
        }
        activity.startActivityForResult(intent, WEB_AUTH_REQUEST_CODE)
    }

    private fun navigateToMoviesScreen() {
        val intent = Intent(activity, MainActivity::class.java)
        activity.startActivityForResult(intent, WEB_AUTH_REQUEST_CODE)
    }
}