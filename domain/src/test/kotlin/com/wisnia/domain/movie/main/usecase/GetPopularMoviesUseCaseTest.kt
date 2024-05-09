package com.wisnia.domain.movie.main.usecase

import com.wisnia.domain.configuration.model.ConfigurationModel
import com.wisnia.domain.configuration.model.image.PosterSizesModel
import com.wisnia.domain.configuration.repository.ConfigurationRepository
import com.wisnia.domain.movie.main.model.MovieModel
import com.wisnia.domain.movie.main.model.ResultModel
import com.wisnia.domain.movie.main.repository.MovieRepository
import io.reactivex.Single
import org.amshove.kluent.any
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

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
        `when`(configurationRepository.configuration()).thenReturn(Single.just(configuration))
        `when`(movieRepository.popularMovies(any())).thenReturn(Single.just(movie))

        tested.execute().blockingGet()

        verify(configurationRepository).configuration()
    }

    @Test
    fun `should get popular movies`() {
        val imagePath = "secureBaseUrl/w342"
        val configuration = configuration.copy(
            secureBaseUrl = "secureBaseUrl/",
            posterSizes = listOf(PosterSizesModel.W342)
        )
        val movie = movie.copy(results = listOf(result))
        `when`(configurationRepository.configuration()).thenReturn(Single.just(configuration))
        `when`(movieRepository.popularMovies(any())).thenReturn(Single.just(movie))

        tested.execute().blockingGet()

        verify(movieRepository).popularMovies(imagePath)
    }
}
