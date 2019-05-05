package com.wisnia.videooo.movies.details.viewmodel

import androidx.lifecycle.MutableLiveData
import com.wisnia.domain.movie.details.usecase.GetMovieDetailsUseCase
import com.wisnia.videooo.common.scheduler.RxScheduler
import com.wisnia.videooo.common.viewmodel.LifecycleViewModel
import com.wisnia.videooo.movies.details.model.MovieDetails
import com.wisnia.videooo.movies.details.model.toUI
import com.wisnia.videooo.movies.main.model.MovieId
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class MovieDetailsViewModel @Inject constructor(
    private val selectedMovieId: MovieId,
    private val getMovieDetailsUsecase: GetMovieDetailsUseCase,
    private val scheduler: RxScheduler
) : LifecycleViewModel() {

    val movieDetails = MutableLiveData<MovieDetails>()

    override fun onInitialize() {
        super.onInitialize()

        getMovieDetailsUsecase.execute(selectedMovieId.id)
            .subscribeOn(scheduler.io())
            .observeOn(scheduler.mainThread())
            .subscribeBy(
                onSuccess = { movieDetails.value = it.toUI() },
                onError = { it.printStackTrace() })
    }
}
