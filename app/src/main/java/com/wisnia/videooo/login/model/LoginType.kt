package com.wisnia.videooo.login.model

import com.wisnia.domain.authentication.model.TokenModel

sealed class LoginType {
    object SignIn : LoginType()
    class SignInWeb(val token: TokenModel) : LoginType()
    object Guest : LoginType()
}
