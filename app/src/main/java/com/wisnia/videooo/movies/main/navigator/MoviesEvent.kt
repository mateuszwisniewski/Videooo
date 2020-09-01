package com.wisnia.videooo.movies.main.navigator

import com.wisnia.videooo.movies.main.model.MovieId

sealed class MoviesEvent {
    data class NavigateToMovieDetails(val movieId: MovieId) : MoviesEvent()
}
