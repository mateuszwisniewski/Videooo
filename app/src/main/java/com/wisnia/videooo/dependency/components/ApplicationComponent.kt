package com.wisnia.videooo.dependency.components

import com.wisnia.videooo.VideoooApplication
import com.wisnia.videooo.dependency.modules.AndroidBindingModule
import com.wisnia.videooo.dependency.modules.ApplicationModule
import com.wisnia.videooo.dependency.modules.HttpModule
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class, AndroidSupportInjectionModule::class,
        AndroidBindingModule::class, HttpModule::class
    ]
)
interface ApplicationComponent {

    fun inject(application: VideoooApplication)
}
