package com.wisnia.videooo.mvp

abstract class BasePresenter<V : View> : Presenter<V> {

    var view: V? = null

    override fun attachUI(view: V) {
        this.view = view
    }

    override fun detachUI() {
        this.view = null
    }
}