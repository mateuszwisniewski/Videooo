package com.wisnia.videooo.repository.token

import com.wisnia.data.authentication.model.TokenEntity
import com.wisnia.data.authentication.repository.token.AuthenticationHeaderInterceptor
import okhttp3.Headers
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import retrofit2.Response

private const val AUTHENTICATION_CALLBACK_VALUE = "example_authentication-callback"

class AuthenticationHeaderExtractorTest {

    private val tested =
        AuthenticationHeaderInterceptor()

    private val tokenResponse = mock<Response<TokenEntity>>()

    @Test
    fun `when send token request then should add authentication header to token`() {
        `when`(tokenResponse.headers()).thenReturn(headers())
        `when`(tokenResponse.body()).thenReturn(token())

        // When
        val observer = tested.intercept(tokenResponse).test()

        // Then
        observer.assertNoErrors()
        observer.assertValue { it.authenticationPage == AUTHENTICATION_CALLBACK_VALUE }
    }

    private fun headers() =
        Headers.of("Authentication-Callback", AUTHENTICATION_CALLBACK_VALUE)

    private fun token() =
        TokenEntity(true, "example_date", "example_token", null)
}
