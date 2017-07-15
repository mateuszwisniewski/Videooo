package com.wisnia.videooo.view

import com.wisnia.videooo.data.authentication.Token
import com.wisnia.videooo.mvp.View

interface LoginView : View {

    fun showError(error: Throwable)

    fun onTokenReceived(token: Token)
}