package com.wisnia.videooo.data.account

import com.squareup.moshi.Json

data class Gravatar(@Json(name = "hash") val hash: String)
