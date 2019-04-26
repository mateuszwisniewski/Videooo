package com.wisnia.data.movie.repository

import com.wisnia.data.movie.api.MovieApi
import com.wisnia.data.movie.model.toDomain
import com.wisnia.domain.movie.model.MovieModel
import com.wisnia.domain.movie.repository.MovieRepository
import io.reactivex.Single

class MovieDataRepository(private val movieApi: MovieApi) : MovieRepository {

    override fun popularMovies(): Single<MovieModel> =
        movieApi.popularMovies().map { movie -> movie.toDomain() }
}
