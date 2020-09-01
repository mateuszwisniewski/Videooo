package com.wisnia.domain.configuration.model.image

sealed class PosterSizesModel(val size: String) {
    object W92 : PosterSizesModel("w92")
    object W154 : PosterSizesModel("w154")
    object W185 : PosterSizesModel("w185")
    object W342 : PosterSizesModel("w342")
    object W500 : PosterSizesModel("w500")
    object W780 : PosterSizesModel("w780")
    object ORIGINAL : PosterSizesModel("original")
}

fun List<PosterSizesModel>.get(posterSizesModel: PosterSizesModel): String =
    first { size -> size == posterSizesModel }.size
