package com.wisnia.data.movie.details.repository

import com.wisnia.data.movie.details.api.MovieDetailsApi
import com.wisnia.data.movie.details.model.toDomain
import com.wisnia.domain.movie.details.model.MovieDetailsModel
import com.wisnia.domain.movie.details.repository.MovieDetailsRepository
import io.reactivex.Single

class MovieDetailsDataRepository(private val movieDetailsApi: MovieDetailsApi) :
    MovieDetailsRepository {

    override fun movieDetails(movieId: Int, imagePath: String): Single<MovieDetailsModel> =
        movieDetailsApi.movieDetails(movieId)
            .map { movieDetails -> movieDetails.toDomain(imagePath) }
}