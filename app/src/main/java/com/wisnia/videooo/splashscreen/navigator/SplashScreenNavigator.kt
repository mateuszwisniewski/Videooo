package com.wisnia.videooo.splashscreen.navigator

import android.content.Intent
import androidx.lifecycle.Observer
import com.wisnia.videooo.common.navigator.Navigator
import com.wisnia.videooo.login.view.LoginActivity
import com.wisnia.videooo.splashscreen.navigator.SplashScreenEvent.NavigateToLoginScreen
import com.wisnia.videooo.splashscreen.view.SplashScreenActivity

class SplashScreenNavigator(private val activity: SplashScreenActivity) :
    Navigator<SplashScreenEvent>(activity) {

    override val navigationObserver: Observer<SplashScreenEvent> = Observer {
        when (it) {
            is NavigateToLoginScreen -> navigateToLoginScreen()
        }
    }

    private fun navigateToLoginScreen() {
        val intent = Intent(activity, LoginActivity::class.java)
        activity.apply {
            startActivity(intent)
            finish()
        }
    }
}
