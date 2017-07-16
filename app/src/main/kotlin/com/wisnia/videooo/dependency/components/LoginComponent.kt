package com.wisnia.videooo.dependency.components

import com.wisnia.videooo.dependency.scope.Presenter
import com.wisnia.videooo.ui.activity.LoginActivity
import dagger.Subcomponent

@Presenter
@Subcomponent
interface LoginComponent {

    fun inject(activity: LoginActivity)
}
