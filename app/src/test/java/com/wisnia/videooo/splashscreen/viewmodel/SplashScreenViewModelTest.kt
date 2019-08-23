package com.wisnia.videooo.splashscreen.viewmodel

import com.nhaarman.mockitokotlin2.verify
import com.wisnia.videooo.splashscreen.navigator.SplashScreenEvent.NavigateToLoginScreen
import com.wisnia.videooo.splashscreen.navigator.SplashScreenNavigator
import org.amshove.kluent.mock
import org.junit.Test

class SplashScreenViewModelTest {

    val navigator = mock<SplashScreenNavigator>()

    val tested = SplashScreenViewModel(navigator)

    @Test
    fun `should subscribe navigator to lifecycle when initialized`() {
        tested.onInitialize()

        verify(navigator).subscribe()
    }

    @Test
    fun `should navigate to login screen`() {
        tested.onInitialize()

        verify(navigator).call(NavigateToLoginScreen)
    }
}
