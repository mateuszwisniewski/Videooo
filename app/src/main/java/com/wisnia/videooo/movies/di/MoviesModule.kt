package com.wisnia.videooo.movies.di

import com.wisnia.data.movie.api.MovieApi
import com.wisnia.data.movie.repository.MovieDataRepository
import com.wisnia.domain.movie.repository.MovieRepository
import com.wisnia.videooo.application.di.scope.Fragment
import com.wisnia.videooo.movies.adapter.PopularMoviesAdapter
import com.wisnia.videooo.movies.viewmodel.MovieItemViewModel
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MoviesModule {

    @Provides
    @Fragment
    fun provideMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

    @Provides
    @Fragment
    fun provideMovieRepository(movieApi: MovieApi): MovieRepository = MovieDataRepository(movieApi)

    @Provides
    @Fragment
    fun providePopularMoviesAdapter(itemViewModel: MovieItemViewModel): PopularMoviesAdapter =
        PopularMoviesAdapter(itemViewModel)

    @Provides
    @Fragment
    fun provideMovieItemViewModel(): MovieItemViewModel = MovieItemViewModel()
}
