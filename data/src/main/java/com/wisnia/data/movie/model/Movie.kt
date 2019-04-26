package com.wisnia.data.movie.model

import com.squareup.moshi.Json
import com.wisnia.domain.movie.model.MovieModel
import com.wisnia.domain.movie.model.ResultModel

data class Movie(
    @Json(name = "page") var page: Int,
    @Json(name = "results") var results: List<Result>,
    @Json(name = "total_results") var totalResults: Int,
    @Json(name = "total_pages") var totalPages: Int
)

data class Result(
    @Json(name = "poster_path") var posterPath: String,
    @Json(name = "adult") var adult: Boolean,
    @Json(name = "overview") var overview: String,
    @Json(name = "release_date") var releaseDate: String,
    @Json(name = "genre_ids") var genreIds: List<Int>,
    @Json(name = "id") var id: Int,
    @Json(name = "original_title") var originalTitle: String,
    @Json(name = "original_language") var originalLanguage: String,
    @Json(name = "title") var title: String,
    @Json(name = "backdrop_path") var backdropPath: String,
    @Json(name = "popularity") var popularity: Double,
    @Json(name = "vote_count") var voteCount: Int,
    @Json(name = "video") var video: Boolean,
    @Json(name = "vote_average") var voteAverage: Double
)

fun Movie.toDomain(): MovieModel = MovieModel(page, results.toDomain(), totalResults, totalPages)

private fun List<Result>.toDomain(): List<ResultModel> = map { result -> result.toDomain() }

private fun Result.toDomain(): ResultModel = ResultModel(
    posterPath,
    adult,
    overview,
    releaseDate,
    genreIds,
    id,
    originalTitle,
    originalLanguage,
    title,
    backdropPath,
    popularity,
    voteCount,
    video,
    voteAverage
)