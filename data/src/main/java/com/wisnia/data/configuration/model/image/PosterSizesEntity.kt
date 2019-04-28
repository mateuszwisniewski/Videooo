package com.wisnia.data.configuration.model.image

import com.wisnia.domain.configuration.model.image.PosterSizesModel

@Suppress("EnumEntryName")
enum class PosterSizesEntity {
    w92, w154, w185, w342, w500, w780, original
}

fun List<PosterSizesEntity>.toDomain(): List<PosterSizesModel> =
    map { posterSizes ->
        when (posterSizes) {
            PosterSizesEntity.w92 -> PosterSizesModel.W92
            PosterSizesEntity.w154 -> PosterSizesModel.W154
            PosterSizesEntity.w185 -> PosterSizesModel.W185
            PosterSizesEntity.w342 -> PosterSizesModel.W342
            PosterSizesEntity.w500 -> PosterSizesModel.W500
            PosterSizesEntity.w780 -> PosterSizesModel.W780
            PosterSizesEntity.original -> PosterSizesModel.ORIGINAL
        }
    }
