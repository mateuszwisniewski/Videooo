package com.wisnia.videooo.movies.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.wisnia.domain.movie.main.model.ResultModel
import com.wisnia.videooo.R
import com.wisnia.videooo.common.view.BindableRecyclerViewAdapter
import com.wisnia.videooo.common.view.BindingViewHolder
import com.wisnia.videooo.databinding.ItemPopularMovieBinding
import com.wisnia.videooo.movies.main.viewmodel.MovieItemViewModel

class PopularMoviesAdapter(private val itemViewModel: MovieItemViewModel) :
    BindableRecyclerViewAdapter<ResultModel>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<ResultModel> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_popular_movie, parent, false)
        return BindingViewHolder(ItemPopularMovieBinding.bind(view), itemViewModel)
    }
}
