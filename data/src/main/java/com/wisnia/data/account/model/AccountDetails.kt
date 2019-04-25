package com.wisnia.data.account.model

import com.squareup.moshi.Json
import com.wisnia.domain.account.model.AccountDetailsModel

data class AccountDetails(
    @Json(name = "avatar") val avatar: Avatar,
    @Json(name = "id") val id: Int,
    @Json(name = "iso_639_1") val iso6391: String,
    @Json(name = "iso_3166_1") val iso31661: String,
    @Json(name = "name") val name: String,
    @Json(name = "include_adult") val includeAdult: Boolean,
    @Json(name = "username") val username: String
)

data class Avatar(@Json(name = "gravatar") val gravatar: Gravatar)

data class Gravatar(@Json(name = "hash") val hash: String)

fun AccountDetails.toDomain() =
    AccountDetailsModel(id, name, username)