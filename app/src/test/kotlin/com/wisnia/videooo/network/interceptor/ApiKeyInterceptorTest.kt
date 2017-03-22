package com.wisnia.videooo.network.interceptor

import okhttp3.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ApiKeyInterceptorTest {

    val API_KEY_NAME = "api_key"
    val EMPTY_API_KEY = ""
    val EXAMPLE_API_KEY = "example_api_key"

    @Mock
    var chain: Interceptor.Chain? = null

    @Before
    fun setUp() {
        `when`(chain!!.proceed(any(Request::class.java)))
                .thenAnswer {
                    Response.Builder()
                            .code(200)
                            .protocol(Protocol.HTTP_1_0)
                            .request(it.arguments[0] as Request)
                            .build()
                }
    }

    @Test(expected = ApiKeyNotFoundException::class)
    fun intercept_whenNoApiKeyInRequestQuery_thenThrowException() {
        given_QueryParameters()

        val interceptor: ApiKeyInterceptor = ApiKeyInterceptor(EMPTY_API_KEY)
        interceptor.intercept(chain!!)
    }

    @Test
    fun intercept_whenApiKeyInRequestQuery() {
        given_QueryParameters()

        val interceptor: ApiKeyInterceptor = ApiKeyInterceptor(EXAMPLE_API_KEY)
        interceptor.intercept(chain!!)
    }

    private fun given_QueryParameters() {
        val httpUrlBuilder: HttpUrl.Builder = HttpUrl.Builder()
                .scheme("http")
                .host("example-host.com")
                .addQueryParameter(API_KEY_NAME, EXAMPLE_API_KEY)

        `when`(chain!!.request()).thenReturn(Request.Builder()
                .url(httpUrlBuilder.build())
                .build())
    }
}