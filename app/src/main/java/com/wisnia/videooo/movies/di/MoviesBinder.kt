package com.wisnia.videooo.movies.di

import com.wisnia.videooo.application.di.scope.Fragment
import com.wisnia.videooo.movies.view.MoviesFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MoviesBinder {

    @ContributesAndroidInjector(modules = [MoviesModule::class])
    @Fragment
    abstract fun bindMoviesFragment(): MoviesFragment
}
