package com.wisnia.videooo.movies.details.model

import com.wisnia.domain.movie.details.model.MovieDetailsModel

data class MovieDetails(
    val backdropPath: String?,
    val id: Int,
    val overview: String,
    val posterPath: Any,
    val releaseDate: String,
    val title: String
)

fun MovieDetailsModel.toUI(): MovieDetails =
    MovieDetails(backdropPath, id, overview, posterPath, releaseDate, title)
