package com.wisnia.data.movie.main.repository

import com.wisnia.data.movie.main.api.MovieApi
import com.wisnia.data.movie.main.model.toDomain
import com.wisnia.domain.movie.main.model.MovieModel
import com.wisnia.domain.movie.main.repository.MovieRepository
import io.reactivex.Single

class MovieDataRepository(private val movieApi: MovieApi) : MovieRepository {

    override fun popularMovies(imagePath: String): Single<MovieModel> =
        movieApi.popularMovies().map { movie -> movie.toDomain(imagePath) }
}
