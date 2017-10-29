package com.wisnia.videooo.splashscreen.presentation

import com.wisnia.videooo.splashscreen.view.SplashScreenView
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SplashScreenPresenterTest {

    @InjectMocks
    lateinit var presenter: SplashScreenPresenter

    @Mock
    lateinit var view: SplashScreenView

    @Test
    fun `when attach view then should show login screen`() {
        // When
        presenter.attachUI(view)

        // Then
        verify(view).showLoginScreen()
    }
}