package com.wisnia.data.movie.api

import com.wisnia.data.movie.model.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    fun popularMovies(): Single<Movie>
}