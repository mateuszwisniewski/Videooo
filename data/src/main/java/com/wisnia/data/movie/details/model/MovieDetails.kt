package com.wisnia.data.movie.details.model

import com.squareup.moshi.Json
import com.wisnia.domain.movie.details.model.MovieDetailsModel

data class MovieDetails(
    @Json(name = "backdrop_path") val backdropPath: String,
    @Json(name = "id") val id: Int,
    @Json(name = "overview") val overview: String,
    @Json(name = "poster_path") val posterPath: Any,
    @Json(name = "release_date") val releaseDate: String,
    @Json(name = "title") val title: String
)

fun MovieDetails.toDomain(imagePath: String): MovieDetailsModel =
    MovieDetailsModel(imagePath.plus(backdropPath), id, overview, posterPath, releaseDate, title)