package com.wisnia.domain.authentication.model

import com.squareup.moshi.Json

data class GuestSession(
    @Json(name = "success") val success: Boolean,
    @Json(name = "guest_session_id") val guestSessionId: String,
    @Json(name = "expires_at") val expiresAt: String
)
