package com.wisnia.domain.movie.usecase

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.wisnia.domain.movie.repository.MovieRepository
import org.junit.Test

class GetPopularMoviesUseCaseTest {

    val movieRepository = mock<MovieRepository>()

    val tested = GetPopularMoviesUseCase(movieRepository)

    @Test
    fun `should get popular movies`() {
        tested.execute()

        verify(movieRepository).popularMovies()
    }
}
