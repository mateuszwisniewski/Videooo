package com.wisnia.videooo.common.extensions

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> AppCompatActivity.viewModel(viewModelFactory: ViewModelProvider.Factory): T =
    ViewModelProviders.of(this, viewModelFactory)[T::class.java]

fun <T : ViewDataBinding> AppCompatActivity.bindViewData(@LayoutRes layout: Int): T =
    DataBindingUtil.setContentView<T>(this, layout).also {
        it.lifecycleOwner = this
    }
