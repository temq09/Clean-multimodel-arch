package com.example.antitheft_impl.di

import com.example.core_db_api.data.DbClientApi
import com.example.core_network_api.data.HttpClientApi
import com.example.module_injector.BaseDependencies
import com.example.purchase_api.domain.PurchaseInteractor

interface AntitheftFeatureDependencies : BaseDependencies {
    fun dbClient(): DbClientApi
    fun httpClient(): HttpClientApi
    fun purchaseInteractor(): PurchaseInteractor
}