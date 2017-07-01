package com.wisnia.videooo.mvp

interface Presenter<in V : View> {
    fun attachUI(view: V)

    fun startPresenting()

    fun detachUI()
}
