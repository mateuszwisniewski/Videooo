package com.wisnia.videooo.dependency.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.wisnia.videooo.login.presentation.LoginViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelClass(LoginViewModel::class)
    internal abstract fun provideLoginViewModel(viewModel: LoginViewModel): ViewModel
}