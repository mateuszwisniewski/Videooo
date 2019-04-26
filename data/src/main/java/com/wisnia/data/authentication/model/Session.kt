package com.wisnia.data.authentication.model

import com.squareup.moshi.Json
import com.wisnia.domain.authentication.model.SessionModel

data class Session(
    @Json(name = "success") val success: Boolean,
    @Json(name = "session_id") val sessionId: String
)

fun Session.toDomain(): SessionModel = SessionModel(success, sessionId)