package com.wisnia.videooo.data.authentication

import com.google.gson.annotations.SerializedName

data class GuestSession(@SerializedName("success") val success: Boolean,
                        @SerializedName("guest_session_id") val guestSessionId: String,
                        @SerializedName("expires_at") val expiresAt: String)
