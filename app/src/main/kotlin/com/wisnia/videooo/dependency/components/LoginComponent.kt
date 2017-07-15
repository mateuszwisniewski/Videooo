package com.wisnia.videooo.dependency.components

import com.wisnia.videooo.dependency.scope.Presenter
import com.wisnia.videooo.ui.activity.LoginActivity
import dagger.Component

@Presenter
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface LoginComponent {

    fun inject(activity: LoginActivity)
}