package com.wisnia.data.authentication.model

import com.squareup.moshi.Json
import com.wisnia.domain.authentication.model.GuestSessionModel

data class GuestSessionEntity(
    @Json(name = "success") val success: Boolean,
    @Json(name = "guest_session_id") val guestSessionId: String,
    @Json(name = "expires_at") val expiresAt: String
)

fun GuestSessionEntity.toDomain(): GuestSessionModel =
    GuestSessionModel(success, guestSessionId, expiresAt)
