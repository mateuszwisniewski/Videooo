package com.wisnia.domain.movie.details.model

data class MovieDetailsModel(
    val backdropPath: String,
    val id: Int,
    val overview: String,
    val posterPath: Any,
    val releaseDate: String,
    val title: String
)