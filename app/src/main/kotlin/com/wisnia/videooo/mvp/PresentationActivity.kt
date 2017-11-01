package com.wisnia.videooo.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import java.lang.ref.WeakReference

abstract class PresentationActivity<in V : View> : AppCompatActivity(), View {

    private lateinit var presenter: Presenter<V>
    private lateinit var view: WeakReference<V>

    protected abstract fun getPresenter(): Presenter<V>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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