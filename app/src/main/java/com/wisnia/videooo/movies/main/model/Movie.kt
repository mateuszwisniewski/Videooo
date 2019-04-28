package com.wisnia.videooo.movies.main.model

import com.wisnia.domain.movie.main.model.MovieModel

data class Movie(
    var posterPath: String,
    var id: Int,
    var title: String
)

fun MovieModel.toUI(): List<Movie> =
    results.map { movie -> Movie(movie.posterPath, movie.id, movie.title) }