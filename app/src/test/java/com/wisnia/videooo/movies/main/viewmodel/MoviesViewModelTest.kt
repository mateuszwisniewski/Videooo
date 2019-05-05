package com.wisnia.videooo.movies.main.viewmodel

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wisnia.domain.movie.main.model.MovieModel
import com.wisnia.domain.movie.main.model.ResultModel
import com.wisnia.domain.movie.main.usecase.GetPopularMoviesUseCase
import com.wisnia.videooo.LiveDataTest
import com.wisnia.videooo.TestRxScheduler
import com.wisnia.videooo.movies.main.model.Movie
import com.wisnia.videooo.movies.main.navigator.MoviesNavigator
import io.reactivex.Single
import org.amshove.kluent.shouldEqual
import org.junit.Before
import org.junit.Test

class MoviesViewModelTest : LiveDataTest() {

    val getPopularMoviesUseCase = mock<GetPopularMoviesUseCase>()
    val navigator = mock<MoviesNavigator>()

    val movieModel = MovieModel(0, emptyList(), 0, 0)

    lateinit var tested: MoviesViewModel

    @Before
    fun setUp() {
        tested = MoviesViewModel(getPopularMoviesUseCase, navigator, TestRxScheduler())
    }

    @Test
    fun `should subscribe navigator when initialized`() {
        whenever(getPopularMoviesUseCase.execute()).thenReturn(Single.never())

        tested.onInitialize()

        verify(navigator).subscribe()
    }

    @Test
    fun `should get popular movies when initialized`() {
        whenever(getPopularMoviesUseCase.execute()).thenReturn(Single.just(movieModel))

        tested.onInitialize()

        verify(getPopularMoviesUseCase).execute()
    }

    @Test
    fun `should map popular movies from domain to ui when successfully loaded`() {
        val movie = movieModel.copy(results = listOf(ResultModel("posterPath", 1, "title")))
        whenever(getPopularMoviesUseCase.execute()).thenReturn(Single.just(movie))

        tested.onInitialize()

        val expected = listOf(Movie("posterPath", 1, "title"))
        tested.popularMovies.value shouldEqual expected
    }
}
