package com.wisnia.videooo.movies.viewmodel

import androidx.lifecycle.MutableLiveData
import com.wisnia.domain.movie.model.ResultModel
import com.wisnia.domain.movie.usecase.GetPopularMoviesUseCase
import com.wisnia.videooo.common.scheduler.RxScheduler
import com.wisnia.videooo.common.viewmodel.LifecycleViewModel
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val scheduler: RxScheduler
) : LifecycleViewModel() {

    val popularMovies = MutableLiveData<List<ResultModel>>()

    override fun onInitialize() {
        super.onInitialize()
        getPopularMovies()
    }

    private fun getPopularMovies() {
        getPopularMoviesUseCase.execute()
            .subscribeOn(scheduler.io)
            .observeOn(scheduler.mainThread)
            .subscribeBy(
                onSuccess = { popularMovies.value = it.results },
                onError = { it.printStackTrace() }
            )
    }
}