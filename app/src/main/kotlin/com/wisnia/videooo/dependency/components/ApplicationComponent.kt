package com.wisnia.videooo.dependency.components

import android.app.Application
import com.wisnia.videooo.dependency.modules.ApplicationModule
import com.wisnia.videooo.dependency.modules.HttpModule
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.repository.authentication.TokenRepository
import dagger.Component
import io.reactivex.Scheduler
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, HttpModule::class))
interface ApplicationComponent {

    fun application(): Application

    fun mainThreadScheduler(): Scheduler

    fun serviceProvider(): HttpServiceProvider

    fun tokenRepository(): TokenRepository
}