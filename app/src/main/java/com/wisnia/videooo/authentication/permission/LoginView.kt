package com.wisnia.videooo.authentication.permission

import com.wisnia.domain.authentication.model.Token
import com.wisnia.videooo.mvp.View

interface LoginView : View {

    fun showError(error: Throwable)

    fun onSignedIn()

    fun onWebsiteTokenReceived(token: Token)
}