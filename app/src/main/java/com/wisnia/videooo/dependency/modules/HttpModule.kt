package com.wisnia.videooo.dependency.modules

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.wisnia.videooo.BuildConfig
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.OkHttpClientProvider
import com.wisnia.videooo.network.RetrofitServiceProvider
import com.wisnia.videooo.network.Timeout
import com.wisnia.videooo.network.interceptor.ApiKeyInterceptor
import com.wisnia.videooo.network.interceptor.data.Interceptors
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val URL = "https://api.themoviedb.org/3/"
private const val CONNECTION_TIMEOUT: Long = 5

@Module(includes = [ApiRepositoryModule::class])
class HttpModule {

    @Singleton
    @Provides
    fun provideHttpService(): HttpServiceProvider {
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .client(getHttpClient())
            .addConverterFactory(getConverterFactory())
            .addCallAdapterFactory(getCallAdapterFactory())
            .build()
        return RetrofitServiceProvider(retrofit)
    }

    private fun getHttpClient(): OkHttpClient {
        val connectionTimeout = getConnectionTimeout()
        val interceptors = getInterceptors()
        return OkHttpClientProvider(interceptors.interceptors, connectionTimeout).okHttpClient
    }

    private fun getInterceptors(): Interceptors {
        val apiKeyInterceptor = ApiKeyInterceptor(BuildConfig.tmdb_api_key)

        val interceptorsList = listOf(apiKeyInterceptor)
        return Interceptors(interceptorsList)
    }

    private fun getConnectionTimeout() = Timeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)

    private fun getConverterFactory() = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()
        .let { MoshiConverterFactory.create(it) }

    private fun getCallAdapterFactory() = CoroutineCallAdapterFactory()
}
