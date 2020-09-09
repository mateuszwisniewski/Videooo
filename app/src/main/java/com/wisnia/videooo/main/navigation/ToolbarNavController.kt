package com.wisnia.videooo.main.navigation

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.wisnia.videooo.R

class ToolbarNavController(
    private val navController: NavController,
    private val toolbar: Toolbar
) : NavController.OnDestinationChangedListener {

    init {
        val configuration = AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController, configuration)
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        when (destination.id) {
            R.id.loginFragment -> toolbar.visibility = GONE
            else -> toolbar.visibility = VISIBLE
        }
    }

    fun observeDestinationChange() {
        navController.addOnDestinationChangedListener(this)
    }

    fun disposeDestinationChange() {
        navController.removeOnDestinationChangedListener(this)
    }
}
