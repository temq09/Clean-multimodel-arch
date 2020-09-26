package com.example.core_network_impl.di

import com.example.core_network_api.data.HttpClient
import com.example.core_network_impl.data.HttpClientImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class NetworkModule {
    @Singleton
    @Binds
    abstract fun provideHttpClientApi(httpClient: HttpClientImpl): HttpClient
}