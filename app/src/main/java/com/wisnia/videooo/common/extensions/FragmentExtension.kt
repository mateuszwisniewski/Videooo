package com.wisnia.videooo.common.extensions

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

inline fun <reified T : ViewModel> Fragment.viewModel(viewModelFactory: ViewModelProvider.Factory): T =
    ViewModelProviders.of(this, viewModelFactory)[T::class.java]

fun <T : ViewDataBinding> Fragment.bindViewData(@LayoutRes layout: Int, container: ViewGroup?): T =
    DataBindingUtil.inflate<T>(layoutInflater, layout, container, false).also {
        it.lifecycleOwner = this
    }
