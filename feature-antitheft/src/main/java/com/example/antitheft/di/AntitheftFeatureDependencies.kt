package com.example.antitheft.di

import com.example.core_db_api.data.DbClientApi
import com.example.core_network_api.data.HttpClientApi
import com.example.purchase_api.domain.PurchaseInteractor

interface AntitheftFeatureDependencies {
    fun dbClient(): DbClientApi
    fun httpClient(): HttpClientApi
    fun purchaseInteractor(): PurchaseInteractor
}