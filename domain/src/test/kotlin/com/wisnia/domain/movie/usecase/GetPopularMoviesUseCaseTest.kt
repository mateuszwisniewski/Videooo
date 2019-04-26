package com.wisnia.domain.movie.usecase

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wisnia.domain.configuration.model.ConfigurationModel
import com.wisnia.domain.configuration.model.image.PosterSizesModel
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import com.wisnia.domain.movie.model.MovieModel
import com.wisnia.domain.movie.model.ResultModel
import com.wisnia.domain.movie.repository.MovieRepository
import io.reactivex.Single
import org.junit.Test

class GetPopularMoviesUseCaseTest {

    val configurationRepository = mock<ConfigurationRepository>()
    val movieRepository = mock<MovieRepository>()

    val configuration = ConfigurationModel("", "", emptyList())
    val movie = MovieModel(0, emptyList(), 0, 0)
    val result = ResultModel("", 0, "")

    val tested = GetPopularMoviesUseCase(movieRepository, configurationRepository)

    @Test
    fun `should get configuration when getting popular movies`() {
        val configuration = configuration.copy(posterSizes = listOf(PosterSizesModel.W342))
        whenever(configurationRepository.configuration()).thenReturn(Single.just(configuration))
        whenever(movieRepository.popularMovies(any())).thenReturn(Single.just(movie))

        tested.execute().blockingGet()

        verify(configurationRepository).configuration()
    }

    @Test
    fun `should get popular movies`() {
        val imagePath = "secureBaseUrl/w342"
        val configuration = configuration.copy(secureBaseUrl = "secureBaseUrl/", posterSizes = listOf(PosterSizesModel.W342))
        val movie = movie.copy(results = listOf(result))
        whenever(configurationRepository.configuration()).thenReturn(Single.just(configuration))
        whenever(movieRepository.popularMovies(any())).thenReturn(Single.just(movie))

        tested.execute().blockingGet()

        verify(movieRepository).popularMovies(imagePath)
    }
}
