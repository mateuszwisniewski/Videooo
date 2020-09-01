package com.wisnia.videooo.login.navigation

import com.wisnia.domain.authentication.model.TokenModel

sealed class LoginEvent {
    data class NavigateToSignInWebsite(val token: TokenModel) : LoginEvent()
    object NavigateToMovies : LoginEvent()
}
