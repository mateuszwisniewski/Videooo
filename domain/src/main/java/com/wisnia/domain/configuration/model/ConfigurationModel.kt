package com.wisnia.domain.configuration.model

data class ConfigurationModel(
    val images: ImagesModel,
    val changeKeys: List<String>
)

data class ImagesModel(
    val baseUrl: String,
    val secureBaseUrl: String,
    val backdropSizes: List<String>,
    val logoSizes: List<String>,
    val posterSizes: List<String>,
    val profileSizes: List<String>,
    val stillSizes: List<String>
)
