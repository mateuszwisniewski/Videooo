package com.wisnia.videooo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.mvp.View

abstract class PresentationActivity<V : View, Component> : AppCompatActivity(), View {

    private lateinit var presenter: Presenter<V>
    private lateinit var view: V
    var component: Component? = null
        get() = component ?: onBuildComponent()

    protected abstract fun onBuildComponent(): Component

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = onBuildComponent()
    }

    protected fun setPresenter(presenter: Presenter<V>, view: V) {
        this.presenter = presenter
        this.view = view
    }

    override fun onStart() {
        super.onStart()
        presenter.attachUI(view)
    }

    override fun onStop() {
        presenter.detachUI()
        super.onStop()
    }
}