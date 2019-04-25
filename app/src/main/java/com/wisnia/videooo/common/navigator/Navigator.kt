package com.wisnia.videooo.common.navigator

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

abstract class Navigator<T>(private val lifecycleOwner: LifecycleOwner) {

    abstract val navigationObserver: Observer<T>
    private val navigateEvent = MutableLiveData<T>()

    fun subscribe() {
        navigateEvent.observe(lifecycleOwner, navigationObserver)
    }

    fun call(event: T? = null) {
        navigateEvent.value = event
    }
}