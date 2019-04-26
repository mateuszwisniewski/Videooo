package com.wisnia.domain.configuration.model

import com.wisnia.domain.configuration.model.image.PosterSizesModel
import com.wisnia.domain.configuration.model.image.get

data class ConfigurationModel(
    val images: ImagesModel,
    val changeKeys: List<String>
)

data class ImagesModel(
    val baseUrl: String,
    val secureBaseUrl: String,
    val backdropSizes: List<String>,
    val logoSizes: List<String>,
    val posterSizes: List<PosterSizesModel>,
    val profileSizes: List<String>,
    val stillSizes: List<String>
)

fun ConfigurationModel.posterImageUrlPrefix(posterSizesModel: PosterSizesModel): String {
    val posterSize = images.posterSizes.get(posterSizesModel)
    return images.baseUrl.plus(posterSize)
}
