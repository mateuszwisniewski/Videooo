package com.wisnia.videooo

import android.app.Activity
import android.app.Application
import com.wisnia.videooo.dependency.components.DaggerApplicationComponent
import com.wisnia.videooo.dependency.modules.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class VideoooApplication : Application(), HasActivityInjector {

    @Inject
    @Suppress("MemberVisibilityCanPrivate")
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
                .inject(this)
    }
}
