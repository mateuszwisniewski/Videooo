package com.wisnia.domain.movie.model

data class MovieModel(
    var page: Int,
    var results: List<ResultModel>,
    var totalResults: Int,
    var totalPages: Int
)

data class ResultModel(
    var posterPath: String,
    var adult: Boolean,
    var overview: String,
    var releaseDate: String,
    var genreIds: List<Int>,
    var id: Int,
    var originalTitle: String,
    var originalLanguage: String,
    var title: String,
    var backdropPath: String,
    var popularity: Double,
    var voteCount: Int,
    var video: Boolean,
    var voteAverage: Double
)