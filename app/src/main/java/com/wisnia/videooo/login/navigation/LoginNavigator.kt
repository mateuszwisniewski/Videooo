package com.wisnia.videooo.login.navigation

import androidx.lifecycle.Observer
import com.wisnia.videooo.common.navigator.Navigator
import com.wisnia.videooo.login.view.LoginActivity

class LoginNavigator(activity: LoginActivity) : Navigator<LoginEvent>(activity) {

    override val navigationObserver: Observer<LoginEvent> = Observer {
    }
}