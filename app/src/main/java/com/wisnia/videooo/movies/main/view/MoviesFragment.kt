package com.wisnia.videooo.movies.main.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.wisnia.videooo.R
import com.wisnia.videooo.common.di.ViewModelFactory
import com.wisnia.videooo.common.extensions.bindViewData
import com.wisnia.videooo.common.extensions.viewModel
import com.wisnia.videooo.databinding.FragmentMoviesBinding
import com.wisnia.videooo.movies.main.adapter.PopularMoviesAdapter
import com.wisnia.videooo.movies.main.viewmodel.MoviesViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class MoviesFragment : Fragment() {

    @Inject
    lateinit var popularMoviesAdapter: PopularMoviesAdapter

    @Inject
    lateinit var factory: ViewModelFactory<MoviesViewModel>

    private val moviesViewModel by lazy<MoviesViewModel> { viewModel(factory) }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
        lifecycle.addObserver(moviesViewModel)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        bindViewData<FragmentMoviesBinding>(R.layout.fragment_movies, container).also {
            it.viewModel = moviesViewModel
        }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val moviesList = view?.findViewById<RecyclerView>(R.id.moviesList)
        moviesList?.adapter = popularMoviesAdapter
    }
}
