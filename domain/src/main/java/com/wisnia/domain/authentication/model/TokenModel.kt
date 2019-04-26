package com.wisnia.domain.authentication.model

import java.io.Serializable

data class TokenModel(
    val success: Boolean,
    val expirationDate: String,
    val token: String,
    var authenticationPage: String?
) : Serializable
