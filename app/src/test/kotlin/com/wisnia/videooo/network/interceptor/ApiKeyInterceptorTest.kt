package com.wisnia.videooo.network.interceptor

import okhttp3.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiKeyInterceptorTest {

    val API_KEY_NAME = "api_key"

    @Mock
    lateinit var chain: Interceptor.Chain

    @Before
    fun setUp() {
        `when`(chain.proceed(any(Request::class.java)))
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
        val apiKey: String = ""

        // When
        val interceptor: ApiKeyInterceptor = ApiKeyInterceptor(apiKey)
        interceptor.intercept(chain)
    }

    @Test
    fun `when intercept with api key in request query then proceed request`() {
        // Given
        val apiKey: String = "example_api_key"
        addApiKeyQueryParameter(apiKey)

        // When
        val interceptor: ApiKeyInterceptor = ApiKeyInterceptor(apiKey)
        interceptor.intercept(chain)

        // Then
        `verify`(chain).proceed(any(Request::class.java))
    }

    private fun addApiKeyQueryParameter(apiKey: String) {
        val httpUrlBuilder: HttpUrl.Builder = HttpUrl.Builder()
                .scheme("http")
                .host("example-host.com")
                .addQueryParameter(API_KEY_NAME, apiKey)

        `when`(chain.request()).thenReturn(Request.Builder()
                .url(httpUrlBuilder.build())
                .build())
    }
}