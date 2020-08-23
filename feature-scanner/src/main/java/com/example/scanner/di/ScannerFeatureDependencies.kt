package com.example.scanner.di

import com.example.core.utils.SomeUtils
import com.example.core_db_api.data.DbClientApi
import com.example.core_network_api.data.HttpClientApi
import com.example.module_injector.BaseDependencies
import com.example.purchase_api.domain.PurchaseInteractor

interface ScannerFeatureDependencies : BaseDependencies {
    fun dbClient(): DbClientApi
    fun httpClient(): HttpClientApi
    fun someUtils(): SomeUtils
    fun purchaseInteractor(): PurchaseInteractor
}