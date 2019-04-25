package com.wisnia.videooo.network.interceptor

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.wisnia.data.network.interceptor.ApiKeyInterceptor
import com.wisnia.data.network.interceptor.ApiKeyNotFoundException
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.Protocol
import okhttp3.Request
import okhttp3.Response
import org.amshove.kluent.any
import org.junit.Before
import org.junit.Test

class ApiKeyInterceptorTest {

    private val apiKeyName = "api_key"

    private val chain = mock<Interceptor.Chain>()

    @Before
    fun setUp() {
        whenever(chain.proceed(any(Request::class)))
            .thenAnswer {
                Response.Builder()
                    .code(200)
                    .protocol(Protocol.HTTP_1_0)
                    .request(it.arguments[0] as Request)
                    .message("OK")
                    .build()
            }
    }

    @Test(expected = ApiKeyNotFoundException::class)
    fun `when intercept with no api key in request query then throw exception`() {
        // Given
        val apiKey = ""

        // When
        val interceptor = ApiKeyInterceptor(apiKey)
        interceptor.intercept(chain)
    }

    @Test
    fun `when intercept with api key in request query then proceed request`() {
        // Given
        val apiKey = "example_api_key"
        addApiKeyQueryParameter(apiKey)

        // When
        val interceptor = ApiKeyInterceptor(apiKey)
        interceptor.intercept(chain)

        // Then
        verify(chain).proceed(any(Request::class))
    }

    private fun addApiKeyQueryParameter(apiKey: String) {
        val httpUrlBuilder: HttpUrl.Builder = HttpUrl.Builder()
            .scheme("http")
            .host("example-host.com")
            .addQueryParameter(apiKeyName, apiKey)

        whenever(chain.request()).thenReturn(
            Request.Builder()
                .url(httpUrlBuilder.build())
                .build()
        )
    }
}