package com.wisnia.videooo.dependency.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.wisnia.videooo.network.HttpServiceProvider
import com.wisnia.videooo.network.OkHttpClientProvider
import com.wisnia.videooo.network.RetrofitServiceProvider
import com.wisnia.videooo.network.data.Timeout
import com.wisnia.videooo.network.interceptor.data.Interceptors
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class HttpModule {

    private val URL = "https://api.themoviedb.org/3/"

    @Singleton
    @Provides
    internal fun provideHttpService(converterFactory: Converter.Factory, callAdapterFactory: CallAdapter.Factory, okHttpClient: OkHttpClient): HttpServiceProvider {
        val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(callAdapterFactory)
                .build()
        return RetrofitServiceProvider(retrofit)
    }

    @Singleton
    @Provides
    internal fun provideHttpClient(interceptors: Interceptors, timeout: Timeout): OkHttpClient {
        val okHttpClientProvider: OkHttpClientProvider = OkHttpClientProvider(interceptors.interceptors, timeout)
        return okHttpClientProvider.getHttpClient()
    }

    @Singleton
    @Provides
    internal fun provideInterceptors(): Interceptors {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val interceptorsList = listOf(loggingInterceptor)
        return Interceptors(interceptorsList)
    }

    @Singleton
    @Provides
    internal fun provideTimeout(): Timeout {
        return Timeout(5, TimeUnit.SECONDS)
    }

    @Singleton
    @Provides
    internal fun provideConverterFactory(): Converter.Factory {
        val gson = GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
        return GsonConverterFactory.create(gson)
    }

    @Singleton
    @Provides
    internal fun provideCallAdapterFactory(): CallAdapter.Factory {
        return RxJavaCallAdapterFactory.create()
    }
}