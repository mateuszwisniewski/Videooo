package com.wisnia.videooo.repository.token

import com.wisnia.videooo.data.authentication.Token
import okhttp3.Headers
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response

private const val AUTHENTICATION_CALLBACK_VALUE = "example_authentication-callback"

@RunWith(MockitoJUnitRunner::class)
class AuthenticationHeaderExtractorTest {

    @InjectMocks
    private lateinit var authenticationHeaderInterceptor: AuthenticationHeaderInterceptor

    @Mock
    private lateinit var tokenResponse: Response<Token>

    @Test
    fun `when send token request then should add authentication header to token`() {
        `when`(tokenResponse.headers()).thenReturn(headers())
        `when`(tokenResponse.body()).thenReturn(token())

        // When
        val observer = authenticationHeaderInterceptor.intercept(tokenResponse).test()

        // Then
        observer.assertNoErrors()
        observer.assertValue { it.authenticationPage == AUTHENTICATION_CALLBACK_VALUE }
    }

    private fun headers() =
            Headers.of("Authentication-Callback", AUTHENTICATION_CALLBACK_VALUE)

    private fun token() =
            Token(true, "example_date", "example_token", null)
}
