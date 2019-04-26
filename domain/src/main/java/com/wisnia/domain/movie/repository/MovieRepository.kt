package com.wisnia.domain.movie.repository

import com.wisnia.domain.movie.model.MovieModel
import io.reactivex.Single

interface MovieRepository {

    fun popularMovies(imagePath: String): Single<MovieModel>
}