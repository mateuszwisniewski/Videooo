package com.wisnia.videooo.main.navigation

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import com.wisnia.videooo.R

class ToolbarNavController(private val toolbar: Toolbar) : NavController.OnDestinationChangedListener {

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        when (destination.id) {
            R.id.loginFragment -> toolbar.visibility = GONE
            else -> toolbar.visibility = VISIBLE
        }
    }

    fun observeDestinationChange(navController: NavController) {
        navController.addOnDestinationChangedListener(this)
    }

    fun disposeDestinationChange(navController: NavController) {
        navController.removeOnDestinationChangedListener(this)
    }
}
