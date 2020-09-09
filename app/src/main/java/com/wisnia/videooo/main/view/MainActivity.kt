package com.wisnia.videooo.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.wisnia.videooo.R
import com.wisnia.videooo.main.navigation.ToolbarNavController
import dagger.Lazy
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.actvity_main.toolbar
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var toolbarNavController: Lazy<ToolbarNavController>

    override fun androidInjector(): AndroidInjector<Any> = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actvity_main)
        setToolbar()
    }

    override fun onResume() {
        super.onResume()
        toolbarNavController.get()
            .observeDestinationChange()
    }

    override fun onPause() {
        super.onPause()
        toolbarNavController.get()
            .disposeDestinationChange()
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
    }
}
