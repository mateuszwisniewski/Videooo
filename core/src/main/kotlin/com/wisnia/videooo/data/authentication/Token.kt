package com.wisnia.videooo.data.authentication

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Token(@SerializedName("success") val success: Boolean,
                 @SerializedName("expires_at") val expirationDate: String,
                 @SerializedName("request_token") val token: String,
                 var authenticationPage: String?) : Serializable
