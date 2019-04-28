package com.wisnia.videooo.movies.details.di

import com.wisnia.videooo.application.di.scope.Fragment
import com.wisnia.videooo.movies.details.view.MovieDetailsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MovieDetailsBinder {

    @ContributesAndroidInjector(modules = [MovieDetailsModule::class])
    @Fragment
    abstract fun bindMovieDetailsFragment(): MovieDetailsFragment
}