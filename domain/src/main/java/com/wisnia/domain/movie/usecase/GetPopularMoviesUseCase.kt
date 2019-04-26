package com.wisnia.domain.movie.usecase

import com.wisnia.domain.movie.model.MovieModel
import com.wisnia.domain.movie.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val movieRepository: MovieRepository) {

    fun execute(): Single<MovieModel> = movieRepository.popularMovies()
}