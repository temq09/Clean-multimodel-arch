package com.example.antitheft_impl.di

import com.example.core_db_api.DbClient
import com.example.core_network_api.data.HttpClient
import com.example.module_injector.BaseDependencies
import com.example.purchase_api.domain.PurchaseInteractor

interface AntitheftFeatureDependencies : BaseDependencies {
    fun dbClient(): DbClient
    fun httpClient(): HttpClient
    fun purchaseInteractor(): PurchaseInteractor
}