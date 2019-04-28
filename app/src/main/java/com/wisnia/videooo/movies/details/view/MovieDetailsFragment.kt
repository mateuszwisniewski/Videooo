package com.wisnia.videooo.movies.details.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wisnia.videooo.R
import com.wisnia.videooo.common.di.ViewModelFactory
import com.wisnia.videooo.common.extensions.bindViewData
import com.wisnia.videooo.common.extensions.viewModel
import com.wisnia.videooo.databinding.FragmentMovieDetailsBinding
import com.wisnia.videooo.movies.details.viewmodel.MovieDetailsViewModel
import com.wisnia.videooo.movies.main.model.MovieId
import com.wisnia.videooo.movies.main.navigator.SELECTED_POPULAR_MOVIE_ID
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MovieDetailsFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelFactory<MovieDetailsViewModel>

    private val movieDetailsViewModel by lazy<MovieDetailsViewModel> { viewModel(factory) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        lifecycle.addObserver(movieDetailsViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        bindViewData<FragmentMovieDetailsBinding>(R.layout.fragment_movie_details, container).also {
            it.viewModel = movieDetailsViewModel
        }.root

    fun selectedPopularMovieId() = arguments?.get(SELECTED_POPULAR_MOVIE_ID) as MovieId
}
