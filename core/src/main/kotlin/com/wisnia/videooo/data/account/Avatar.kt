package com.wisnia.videooo.data.account

import com.squareup.moshi.Json

data class Avatar(@Json(name = "gravatar") val gravatar: Gravatar)
