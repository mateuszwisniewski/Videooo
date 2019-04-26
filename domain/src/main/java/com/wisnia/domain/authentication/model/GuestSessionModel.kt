package com.wisnia.domain.authentication.model

data class GuestSessionModel(
    val success: Boolean,
    val guestSessionId: String,
    val expiresAt: String
)
