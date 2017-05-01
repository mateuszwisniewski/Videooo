package com.wisnia.videooo.data.authentication

import com.google.gson.annotations.SerializedName

data class Session(@SerializedName("success") val success: Boolean,
                   @SerializedName("session_id") val sessionId: String)
