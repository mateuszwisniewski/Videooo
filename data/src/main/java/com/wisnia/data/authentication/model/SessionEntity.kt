package com.wisnia.data.authentication.model

import com.squareup.moshi.Json
import com.wisnia.domain.authentication.model.SessionModel

data class SessionEntity(
    @Json(name = "success") val success: Boolean,
    @Json(name = "session_id") val sessionId: String
)

fun SessionEntity.toDomain(): SessionModel = SessionModel(success, sessionId)
