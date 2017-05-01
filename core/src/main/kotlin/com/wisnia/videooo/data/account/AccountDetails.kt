package com.wisnia.videooo.data.account

import com.google.gson.annotations.SerializedName

data class AccountDetails(@SerializedName("avatar") val avatar: Avatar,
                          @SerializedName("id") val id: Int,
                          @SerializedName("iso_639_1") val iso6391: String,
                          @SerializedName("iso_3166_1") val iso31661: String,
                          @SerializedName("name") val name: String,
                          @SerializedName("include_adult") val includeAdult: Boolean,
                          @SerializedName("username") val username: String)
