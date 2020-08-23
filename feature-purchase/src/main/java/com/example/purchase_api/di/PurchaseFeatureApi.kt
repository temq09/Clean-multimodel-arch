package com.example.purchase_api.di

import com.example.module_injector.BaseAPI
import com.example.purchase_api.domain.PurchaseInteractor

interface PurchaseFeatureApi : BaseAPI {
    fun purchaseInteractor(): PurchaseInteractor
}