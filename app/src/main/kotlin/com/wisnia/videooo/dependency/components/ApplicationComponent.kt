package com.wisnia.videooo.dependency.components

import android.app.Application
import com.wisnia.videooo.dependency.modules.ApplicationModule
import com.wisnia.videooo.dependency.modules.HttpModule
import com.wisnia.videooo.network.HttpServiceProvider
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, HttpModule::class))
interface ApplicationComponent {

    fun application(): Application

    fun serviceProvider(): HttpServiceProvider
}