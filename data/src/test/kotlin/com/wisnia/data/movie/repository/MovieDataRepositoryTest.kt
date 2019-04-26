package com.wisnia.data.movie.repository

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wisnia.data.movie.api.MovieApi
import com.wisnia.data.movie.model.Movie
import com.wisnia.domain.movie.model.MovieModel
import io.reactivex.Single
import org.amshove.kluent.mock
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieDataRepositoryTest {

    val movieApi = mock<MovieApi>()

    val movie = Movie(0, emptyList(), 0, 0)

    val tested = MovieDataRepository(movieApi)

    @Test
    fun `should get popular movies`() {
        whenever(movieApi.popularMovies()).thenReturn(Single.never())
        val imagePath = "imagePath/"

        tested.popularMovies(imagePath)

        verify(movieApi).popularMovies()
    }

    @Test
    fun `should get popular movies and map it to domain`() {
        whenever(movieApi.popularMovies()).thenReturn(Single.just(movie))
        val imagePath = "imagePath/"

        val result = tested.popularMovies(imagePath).blockingGet()

        val expected = MovieModel(0, emptyList(), 0, 0)
        result shouldEqual expected
    }
}