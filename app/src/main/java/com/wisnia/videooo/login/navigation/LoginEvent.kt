package com.wisnia.videooo.login.navigation

import com.wisnia.domain.authentication.model.Token

sealed class LoginEvent {
    data class NavigateToSignInWebsite(val token: Token) : LoginEvent()
    object NavigateToMovies : LoginEvent()
}