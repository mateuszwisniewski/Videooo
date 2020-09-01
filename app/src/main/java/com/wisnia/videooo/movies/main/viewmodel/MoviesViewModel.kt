package com.wisnia.videooo.movies.main.viewmodel

import androidx.lifecycle.MutableLiveData
import com.wisnia.domain.movie.main.usecase.GetPopularMoviesUseCase
import com.wisnia.videooo.common.scheduler.RxScheduler
import com.wisnia.videooo.common.viewmodel.LifecycleViewModel
import com.wisnia.videooo.movies.main.model.Movie
import com.wisnia.videooo.movies.main.model.toUI
import com.wisnia.videooo.movies.main.navigator.MoviesNavigator
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val navigator: MoviesNavigator,
    private val scheduler: RxScheduler
) : LifecycleViewModel() {

    val popularMovies = MutableLiveData<List<Movie>>()

    override fun onInitialize() {
        super.onInitialize()
        getPopularMovies()
        navigator.subscribe()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase.execute()
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
            .subscribeBy(
                onSuccess = { popularMovies.value = it.toUI() },
                onError = { it.printStackTrace() }
            )
    }
}
