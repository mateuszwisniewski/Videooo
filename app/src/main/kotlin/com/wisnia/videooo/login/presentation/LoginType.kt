package com.wisnia.videooo.login.presentation

import com.wisnia.videooo.data.authentication.Token

sealed class LoginType {
    object SignIn : LoginType()
    class SignInWeb(val token: Token) : LoginType()
    object Guest : LoginType()
}
