package com.wisnia.videooo.authentication.view

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.mvp.View

interface LoginView : View {

    fun showError(error: Throwable)

    fun onSignedIn(token: Token)

    fun onSignedInWebsite(token: Token)
}