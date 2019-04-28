package com.wisnia.data.configuration.model

import com.squareup.moshi.Json
import com.wisnia.data.configuration.model.image.PosterSizesEntity
import com.wisnia.data.configuration.model.image.toDomain
import com.wisnia.domain.configuration.model.ConfigurationModel

data class ConfigurationEntity(
    @Json(name = "images") val images: ImagesEntity,
    @Json(name = "change_keys") val changeKeys: List<String>
)

data class ImagesEntity(
    @Json(name = "base_url") val baseUrl: String,
    @Json(name = "secure_base_url") val secureBaseUrl: String,
    @Json(name = "backdrop_sizes") val backdropSizes: List<String>,
    @Json(name = "logo_sizes") val logoSizes: List<String>,
    @Json(name = "poster_sizes") val posterSizes: List<PosterSizesEntity>,
    @Json(name = "profile_sizes") val profileSizes: List<String>,
    @Json(name = "still_sizes") val stillSizes: List<String>
)

fun ConfigurationEntity.toDomain(): ConfigurationModel =
    ConfigurationModel(images.baseUrl, images.secureBaseUrl, images.posterSizes.toDomain())