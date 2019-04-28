package com.wisnia.videooo.movies.main.navigator

import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.wisnia.videooo.R
import com.wisnia.videooo.common.navigator.Navigator
import com.wisnia.videooo.movies.main.model.MovieId
import com.wisnia.videooo.movies.main.navigator.MoviesEvent.NavigateToMovieDetails
import com.wisnia.videooo.movies.main.view.MoviesFragment

const val SELECTED_POPULAR_MOVIE_ID = "SELECTED_POPULAR_MOVIE_ID"

class MoviesNavigator(private val fragment: MoviesFragment) : Navigator<MoviesEvent>(fragment) {

    private val navController: NavController by lazy {
        NavHostFragment.findNavController(fragment)
    }

    override val navigationObserver: Observer<MoviesEvent> = Observer {
        when (it) {
            is NavigateToMovieDetails -> navigateToMovieDetails(it.movieId)
        }
    }

    private fun navigateToMovieDetails(movieId: MovieId) {
        val bundle = bundleOf(SELECTED_POPULAR_MOVIE_ID to movieId)
        navController.navigate(R.id.action_fragmentMovies_to_movieDetailsFragment, bundle)
    }
}
