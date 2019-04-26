package com.wisnia.videooo.main.di

import com.wisnia.videooo.application.di.scope.Activity
import com.wisnia.videooo.main.view.MainActivity
import com.wisnia.videooo.movies.di.MoviesBinder
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainBinder {

    @ContributesAndroidInjector(modules = [MainModule::class, MoviesBinder::class])
    @Activity
    abstract fun bindMainActivity(): MainActivity
}
