package com.example.purchase_impl.di

import com.example.core_network_api.data.HttpClientApi
import com.example.module_injector.BaseDependencies

interface PurchaseFeatureDependencies : BaseDependencies {
    fun httpClient(): HttpClientApi
}