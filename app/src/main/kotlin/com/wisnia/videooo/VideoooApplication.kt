package com.wisnia.videooo

import android.app.Application
import com.wisnia.videooo.dependency.components.ApplicationComponent
import com.wisnia.videooo.dependency.components.DaggerApplicationComponent
import com.wisnia.videooo.dependency.modules.ApplicationModule

class VideoooApplication : Application() {

    lateinit private var appComponent: ApplicationComponent

    fun getAppComponent(): ApplicationComponent {
        return appComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = buildApplicationComponent()
    }

    private fun buildApplicationComponent(): ApplicationComponent {
        return DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }
}
