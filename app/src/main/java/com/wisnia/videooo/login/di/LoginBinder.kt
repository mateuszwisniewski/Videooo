package com.wisnia.videooo.login.di

import com.wisnia.videooo.application.di.scope.Activity
import com.wisnia.videooo.login.view.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginBinder {

    @ContributesAndroidInjector(modules = [LoginModule::class])
    @Activity
    abstract fun bindLoginFragment(): LoginFragment
}
