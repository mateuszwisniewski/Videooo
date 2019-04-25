package com.wisnia.videooo.splashscreen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisnia.videooo.common.extensions.viewModel
import com.wisnia.videooo.dependency.factory.ViewModelFactory
import com.wisnia.videooo.splashscreen.viewmodel.SplashScreenViewModel
import dagger.android.AndroidInjection
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<SplashScreenViewModel>

    private val splashScreenViewModel by lazy<SplashScreenViewModel> { viewModel(viewModelFactory) }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(splashScreenViewModel)
    }
}
