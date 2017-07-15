package com.wisnia.videooo.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.wisnia.videooo.mvp.Presenter
import com.wisnia.videooo.mvp.View
import java.lang.ref.WeakReference

abstract class PresentationActivity<in V : View, Component> : AppCompatActivity(), View {

    private lateinit var presenter: Presenter<V>
    private lateinit var view: WeakReference<V>
    var component: Component? = null
        get() = field ?: onBuildComponent()

    protected abstract fun onBuildComponent(): Component

    protected abstract fun getPresenter(): Presenter<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = onBuildComponent()
        presenter = getPresenter()
    }

    override fun onStart() {
        super.onStart()
        attachUI()
    }

    @Suppress("UNCHECKED_CAST")
    private fun attachUI() {
        presenter.attachUI(this as V)
    }

    override fun onStop() {
        if (isFinishing) {
            detachUI()
        }
        super.onStop()
    }

    private fun detachUI() {
        presenter.detachUI()
    }
}