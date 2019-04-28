package com.wisnia.data.movie.details.api

import com.wisnia.data.movie.details.model.MovieDetails
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieDetailsApi {

    @GET("movie/{movie_id}")
    fun movieDetails(@Path("movie_id") movieId: Int): Single<MovieDetails>
}
