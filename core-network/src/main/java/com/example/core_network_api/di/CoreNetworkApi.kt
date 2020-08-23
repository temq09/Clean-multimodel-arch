package com.example.core_network_api.di

import com.example.core_network_api.data.HttpClientApi
import com.example.module_injector.BaseAPI

interface CoreNetworkApi: BaseAPI {
    fun httpClientApi(): HttpClientApi
}