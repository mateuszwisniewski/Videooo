package com.wisnia.data.movie.main.repository

import com.wisnia.data.movie.main.api.MovieApi
import com.wisnia.data.movie.main.model.MovieEntity
import com.wisnia.domain.movie.main.model.MovieModel
import io.reactivex.Single
import org.amshove.kluent.mock
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

class MovieDataRepositoryTest {

    val movieApi = mock<MovieApi>()

    val movie = MovieEntity(0, emptyList(), 0, 0)

    val tested = MovieDataRepository(movieApi)

    @Test
    fun `should get popular movies`() {
        `when`(movieApi.popularMovies()).thenReturn(Single.never())
        val imagePath = "imagePath/"

        tested.popularMovies(imagePath)

        verify(movieApi).popularMovies()
    }

    @Test
    fun `should get popular movies and map it to domain`() {
        `when`(movieApi.popularMovies()).thenReturn(Single.just(movie))
        val imagePath = "imagePath/"

        val result = tested.popularMovies(imagePath).blockingGet()

        val expected = MovieModel(0, emptyList(), 0, 0)
        result shouldBeEqualTo expected
    }
}
