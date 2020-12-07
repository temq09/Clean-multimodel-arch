package com.example.core_network_di

import com.example.core_network_api.data.HttpClient
import com.example.core_network_impl.HttpClientImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpClientApi(): HttpClient =
            HttpClientImpl()
}