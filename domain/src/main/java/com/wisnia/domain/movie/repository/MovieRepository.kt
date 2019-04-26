package com.wisnia.domain.movie.repository

import com.wisnia.domain.movie.model.Movie
import io.reactivex.Single

interface MovieRepository {

    fun popularMovies(): Single<Movie>
}