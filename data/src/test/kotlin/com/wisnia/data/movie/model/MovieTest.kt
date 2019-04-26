package com.wisnia.data.movie.model

import com.wisnia.domain.movie.model.MovieModel
import com.wisnia.domain.movie.model.ResultModel
import org.amshove.kluent.shouldEqual
import org.junit.Test

class MovieTest {

    val movie = Movie(0, emptyList(), 0, 0)
    val movieResult = Result("", false, "", "", emptyList(), 0, "", "", "", "", 0.0, 0, false, 0.0)

    @Test
    fun `should map movie to domain`() {
        val movie = movie.copy(1, emptyList(), 2, 3)
        val imagePath = "imagePath/"

        val result = movie.toDomain(imagePath)

        val expected = MovieModel(1, emptyList(), 2, 3)
        result shouldEqual expected
    }

    @Test
    fun `should map list of movie results list to domain`() {
        val movieResults = listOf(movieResult.copy(posterPath = "posterPath", id = 1, title = "title"))
        val imagePath = "imagePath/"

        val result = movieResults.toDomain(imagePath)

        val expected = listOf(ResultModel("${imagePath}posterPath", 1, "title"))
        result shouldEqual expected
    }

    @Test
    fun `should map movie results list to domain`() {
        val movieResult = movieResult.copy(posterPath = "posterPath", id = 1, title = "title")
        val imagePath = "imagePath/"

        val result = movieResult.toDomain(imagePath)

        val expected = ResultModel("${imagePath}posterPath", 1, "title")
        result shouldEqual expected
    }
}
