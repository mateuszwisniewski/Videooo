package com.wisnia.videooo.movies.main.model

import com.wisnia.domain.movie.main.model.MovieModel
import com.wisnia.domain.movie.main.model.ResultModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieTest {

    @Test
    fun `should map domain movie model to ui`() {
        val movieResult = ResultModel("posterPath", 1, "title")
        val movie = MovieModel(0, listOf(movieResult), 0, 0)

        val result = movie.toUI()

        val expected = listOf(Movie("posterPath", 1, "title"))
        result shouldEqual expected
    }
}
