package com.wisnia.videooo.common.navigator

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

abstract class Navigator<T>(private val lifecycleOwner: LifecycleOwner) {

    abstract val navigationObserver: Observer<T>
    private val navigationEvent = MutableLiveData<T>()

    fun subscribe() {
        navigationEvent.observe(lifecycleOwner, navigationObserver)
    }

    fun call(event: T? = null) {
        navigationEvent.value = event
    }
}
