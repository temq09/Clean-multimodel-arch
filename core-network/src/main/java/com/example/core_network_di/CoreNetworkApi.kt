package com.example.core_network_di

import com.example.core_network_api.data.HttpClient
import com.example.module_injector.BaseAPI

interface CoreNetworkApi: BaseAPI {
    fun httpClient(): HttpClient
}