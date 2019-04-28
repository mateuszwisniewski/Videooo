package com.wisnia.videooo.movies.details.model

import com.wisnia.domain.movie.details.model.MovieDetailsModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieDetailsTest {

    @Test
    fun `should map domain movie details model to ui`() {
        val movieDetails =
            MovieDetailsModel("backdropPath", 1, "overview", "posterPath", "releaseDate", "title")

        val result = movieDetails.toUI()

        val expected =
            MovieDetails("backdropPath", 1, "overview", "posterPath", "releaseDate", "title")
        result shouldEqual expected
    }
}