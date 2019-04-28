package com.wisnia.data.movie.main.api

import com.wisnia.data.movie.main.model.Movie
import io.reactivex.Single
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    fun popularMovies(): Single<Movie>
}