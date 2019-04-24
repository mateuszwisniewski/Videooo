package com.wisnia.videooo.login

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity

fun <T : ViewDataBinding> AppCompatActivity.bindData(@LayoutRes layout: Int): T =
    DataBindingUtil.setContentView<T>(this, layout).also {
        it.lifecycleOwner = this
    }
