package com.wisnia.videooo.login.model

import com.wisnia.domain.authentication.model.Token

sealed class LoginType {
    object SignIn : LoginType()
    class SignInWeb(val token: Token) : LoginType()
    object Guest : LoginType()
}
