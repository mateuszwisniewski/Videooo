package com.wisnia.videooo.application

import android.app.Activity
import android.app.Application
import com.wisnia.videooo.application.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class VideoooApplication : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    override fun onCreate() {
        super.onCreate()
        injectApplicationComponent()
    }

    private fun injectApplicationComponent() {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }
}
