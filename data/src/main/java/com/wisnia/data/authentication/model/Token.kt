package com.wisnia.data.authentication.model

import com.squareup.moshi.Json
import com.wisnia.domain.authentication.model.TokenModel
import java.io.Serializable

data class Token(
    @Json(name = "success") val success: Boolean,
    @Json(name = "expires_at") val expirationDate: String,
    @Json(name = "request_token") val token: String,
    var authenticationPage: String?
) : Serializable

fun Token.toDomain(): TokenModel = TokenModel(success, expirationDate, token, authenticationPage)