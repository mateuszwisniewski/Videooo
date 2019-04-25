package com.wisnia.domain.authentication.model

import com.squareup.moshi.Json
import java.io.Serializable

data class Token(
    @Json(name = "success") val success: Boolean,
    @Json(name = "expires_at") val expirationDate: String,
    @Json(name = "request_token") val token: String,
    var authenticationPage: String?
) : Serializable
