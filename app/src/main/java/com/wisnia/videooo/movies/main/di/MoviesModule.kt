package com.wisnia.videooo.movies.main.di

import com.wisnia.data.configuration.api.ConfigurationApi
import com.wisnia.data.configuration.repository.ConfigurationDataRepository
import com.wisnia.data.movie.main.api.MovieApi
import com.wisnia.data.movie.main.repository.MovieDataRepository
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import com.wisnia.domain.movie.main.repository.MovieRepository
import com.wisnia.videooo.application.di.scope.Fragment
import com.wisnia.videooo.movies.main.adapter.PopularMoviesAdapter
import com.wisnia.videooo.movies.main.navigator.MoviesNavigator
import com.wisnia.videooo.movies.main.view.MoviesFragment
import com.wisnia.videooo.movies.main.viewmodel.MovieItemViewModel
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
    fun provideMovieItemViewModel(navigator: MoviesNavigator): MovieItemViewModel =
        MovieItemViewModel(navigator)

    @Provides
    @Fragment
    fun provideMoviesNavigator(fragment: MoviesFragment): MoviesNavigator =
        MoviesNavigator(fragment)

    @Provides
    @Fragment
    fun provideConfigurationApi(retrofit: Retrofit): ConfigurationApi =
        retrofit.create(ConfigurationApi::class.java)

    @Provides
    @Fragment
    fun provideConfigurationRepository(configurationApi: ConfigurationApi): ConfigurationRepository =
        ConfigurationDataRepository(configurationApi)
}
