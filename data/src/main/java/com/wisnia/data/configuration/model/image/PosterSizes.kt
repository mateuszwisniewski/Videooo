package com.wisnia.data.configuration.model.image

import com.wisnia.domain.configuration.model.image.PosterSizesModel

@Suppress("EnumEntryName")
enum class PosterSizes {
    w92, w154, w185, w342, w500, w780, original
}

fun List<PosterSizes>.toDomain(): List<PosterSizesModel> =
    map { posterSizes ->
        when (posterSizes) {
            PosterSizes.w92 -> PosterSizesModel.W92
            PosterSizes.w154 -> PosterSizesModel.W154
            PosterSizes.w185 -> PosterSizesModel.W185
            PosterSizes.w342 -> PosterSizesModel.W342
            PosterSizes.w500 -> PosterSizesModel.W500
            PosterSizes.w780 -> PosterSizesModel.W780
            PosterSizes.original -> PosterSizesModel.ORIGINAL
        }
    }
