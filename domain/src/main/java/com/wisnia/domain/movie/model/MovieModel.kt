package com.wisnia.domain.movie.model

data class MovieModel(
    var page: Int,
    var results: List<ResultModel>,
    var totalResults: Int,
    var totalPages: Int
)

data class ResultModel(
    var posterPath: String,
    var id: Int,
    var title: String
)
