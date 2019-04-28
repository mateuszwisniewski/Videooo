package com.wisnia.videooo.movies.main.viewmodel

import com.wisnia.videooo.common.viewmodel.LifecycleViewModel
import com.wisnia.videooo.movies.main.model.MovieId
import com.wisnia.videooo.movies.main.navigator.MoviesEvent.NavigateToMovieDetails
import com.wisnia.videooo.movies.main.navigator.MoviesNavigator

class MovieItemViewModel(private val navigator: MoviesNavigator) : LifecycleViewModel() {

    fun onMovieItemClick(movieId: Int) {
        navigator.call(NavigateToMovieDetails(MovieId(movieId)))
    }
}
