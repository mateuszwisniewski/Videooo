package com.wisnia.domain.movie.details.repository

import com.wisnia.domain.movie.details.model.MovieDetailsModel
import io.reactivex.Single

interface MovieDetailsRepository {

    fun movieDetails(movieId: Int, imagePath: String): Single<MovieDetailsModel>
}
