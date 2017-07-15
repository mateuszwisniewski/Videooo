package com.wisnia.videooo.mvp

import java.lang.ref.WeakReference

abstract class BasePresenter<V : View> : Presenter<V> {

    protected var view: WeakReference<V>? = null
    private var firstAttach = true

    override fun attachUI(view: V) {
        this.view = WeakReference(view)

        if (firstAttach) {
            startPresenting()
            firstAttach = firstAttach.not()
        }
    }

    override fun startPresenting() {}

    override fun detachUI() {
        this.view?.clear()
    }
}