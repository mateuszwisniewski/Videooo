package com.wisnia.videooo.login

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

fun <T : ViewDataBinding> AppCompatActivity.bindData(@LayoutRes layout: Int): T =
    DataBindingUtil.setContentView<T>(this, layout).also {
        it.lifecycleOwner = this
    }
