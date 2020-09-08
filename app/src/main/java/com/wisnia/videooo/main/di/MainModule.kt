package com.wisnia.videooo.main.di

import androidx.appcompat.widget.Toolbar
import com.wisnia.videooo.R
import com.wisnia.videooo.application.di.scope.Activity
import com.wisnia.videooo.main.navigation.ToolbarNavController
import com.wisnia.videooo.main.view.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @Activity
    fun provideToolbarNavController(activity: MainActivity): ToolbarNavController {
        val toolbar = activity.findViewById<Toolbar>(R.id.toolbar)
        return ToolbarNavController(toolbar)
    }
}
