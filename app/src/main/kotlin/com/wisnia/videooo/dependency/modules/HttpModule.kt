package com.wisnia.videooo.dependency.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.wisnia.videooo.BuildConfig
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.OkHttpClientProvider
import com.wisnia.videooo.network.RetrofitServiceProvider
import com.wisnia.videooo.network.data.Timeout
import com.wisnia.videooo.network.interceptor.ApiKeyInterceptor
import com.wisnia.videooo.network.interceptor.data.Interceptors
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

private const val URL = "https://api.themoviedb.org/3/"
private const val CONNECTION_TIMEOUT: Long = 5

@Module(includes = arrayOf(ApiRepositoryModule::class))
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

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptorsList = listOf(apiKeyInterceptor, loggingInterceptor)
        return Interceptors(interceptorsList)
    }

    private fun getConnectionTimeout() = Timeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)

    private fun getConverterFactory() = GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()
            .let { GsonConverterFactory.create(it) }

    private fun getCallAdapterFactory() = RxJava2CallAdapterFactory.create()
}
