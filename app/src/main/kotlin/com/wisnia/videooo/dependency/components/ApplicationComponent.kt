package com.wisnia.videooo.dependency.components

import com.wisnia.videooo.dependency.modules.ApplicationModule
import com.wisnia.videooo.dependency.modules.HttpModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, HttpModule::class))
interface ApplicationComponent {

    fun addLoginComponent(): LoginComponent
}
