package com.wisnia.videooo.common.viewmodel

import androidx.annotation.CallSuper
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ViewModel

open class LifecycleViewModel : ViewModel(), LifecycleObserver {

    private var initialized = true

    open fun onInitialize() {
    }

    @CallSuper
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    open fun onCreate() {
        if (initialized) {
            onInitialize()
            initialized = false
        }
    }
}