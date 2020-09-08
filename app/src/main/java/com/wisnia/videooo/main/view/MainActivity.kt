package com.wisnia.videooo.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
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

    private val navController: NavController by lazy { findNavController(R.id.main_nav_host_fragment) }

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
            .observeDestinationChange(navController)
    }

    override fun onPause() {
        super.onPause()
        toolbarNavController.get()
            .disposeDestinationChange(navController)
    }

    private fun setToolbar() {
        setSupportActionBar(toolbar)
    }
}
