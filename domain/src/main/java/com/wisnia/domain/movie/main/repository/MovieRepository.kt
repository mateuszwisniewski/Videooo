package com.wisnia.domain.movie.main.repository

import com.wisnia.domain.movie.main.model.MovieModel
import io.reactivex.Single

interface MovieRepository {

    fun popularMovies(imagePath: String): Single<MovieModel>
}
