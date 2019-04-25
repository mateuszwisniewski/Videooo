package com.wisnia.videooo.login.navigation

import android.content.Intent
import androidx.lifecycle.Observer
import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.authentication.view.AuthenticationActivity
import com.wisnia.videooo.common.navigator.Navigator
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToSignIn
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToSignInAsGuest
import com.wisnia.videooo.login.navigation.LoginEvent.NavigateToSignInWebsite
import com.wisnia.videooo.login.view.LoginActivity
import com.wisnia.videooo.login.view.TOKEN_KEY

const val WEB_AUTH_REQUEST_CODE = 101

class LoginNavigator(val activity: LoginActivity) : Navigator<LoginEvent>(activity) {

    override val navigationObserver: Observer<LoginEvent> = Observer {
        when (it) {
            is NavigateToSignIn -> TODO("Not implemented")
            is NavigateToSignInWebsite -> showAuthenticationScreen(it.token)
            is NavigateToSignInAsGuest -> TODO("Not implemented")
        }
    }

    private fun showAuthenticationScreen(token: Token) {
        val intent = Intent(activity, AuthenticationActivity::class.java).apply {
            putExtra(TOKEN_KEY, token)
        }
        activity.startActivityForResult(intent, WEB_AUTH_REQUEST_CODE)
    }
}