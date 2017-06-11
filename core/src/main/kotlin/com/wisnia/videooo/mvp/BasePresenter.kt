package com.wisnia.videooo.mvp

abstract class BasePresenter<V : View> : Presenter<V> {

    var view: V? = null
    private var firstAttach = true

    override fun attachUI(view: V) {
        this.view = view

        if (firstAttach) {
            startPresenting()
            firstAttach = firstAttach.not()
        }
    }

    override fun detachUI() {
        this.view = null
    }
}