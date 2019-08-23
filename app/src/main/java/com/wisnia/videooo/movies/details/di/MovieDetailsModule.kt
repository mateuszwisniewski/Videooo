package com.wisnia.videooo.movies.details.di

import com.wisnia.data.configuration.api.ConfigurationApi
import com.wisnia.data.configuration.repository.ConfigurationDataRepository
import com.wisnia.data.movie.details.api.MovieDetailsApi
import com.wisnia.data.movie.details.repository.MovieDetailsDataRepository
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import com.wisnia.domain.movie.details.repository.MovieDetailsRepository
import com.wisnia.videooo.application.di.scope.Fragment
import com.wisnia.videooo.movies.details.view.MovieDetailsFragment
import com.wisnia.videooo.movies.main.model.MovieId
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class MovieDetailsModule {

    @Provides
    @Fragment
    fun provideSelectedPopularMovieId(fragment: MovieDetailsFragment): MovieId =
        fragment.selectedPopularMovieId()

    @Provides
    @Fragment
    fun provideMovieDetailsRepository(movieDetailsApi: MovieDetailsApi): MovieDetailsRepository =
        MovieDetailsDataRepository(movieDetailsApi)

    @Provides
    @Fragment
    fun provideMovieDetailsApi(retrofit: Retrofit): MovieDetailsApi =
        retrofit.create(MovieDetailsApi::class.java)

    @Provides
    @Fragment
    fun provideConfigurationApi(retrofit: Retrofit): ConfigurationApi =
        retrofit.create(ConfigurationApi::class.java)

    @Provides
    @Fragment
    fun provideConfigurationRepository(configurationApi: ConfigurationApi): ConfigurationRepository =
        ConfigurationDataRepository(configurationApi)
}
