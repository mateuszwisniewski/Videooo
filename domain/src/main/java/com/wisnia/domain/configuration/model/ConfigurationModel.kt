package com.wisnia.domain.configuration.model

import com.wisnia.domain.configuration.model.image.PosterSizesModel
import com.wisnia.domain.configuration.model.image.get

data class ConfigurationModel(
    val baseUrl: String,
    val secureBaseUrl: String,
    val posterSizes: List<PosterSizesModel>
)

fun ConfigurationModel.posterImagePath(posterSizesModel: PosterSizesModel): String {
    val posterSize = posterSizes.get(posterSizesModel)
    return secureBaseUrl.plus(posterSize)
}
