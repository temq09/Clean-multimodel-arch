package com.example.purchase_impl.di

import com.example.core_network_api.data.HttpClient
import com.example.module_injector.BaseDependencies

interface PurchaseFeatureDependencies : BaseDependencies {
    fun httpClient(): HttpClient
}