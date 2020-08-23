package com.example.purchase_api.di

import com.example.purchase_api.domain.PurchaseInteractor

interface PurchaseFeatureApi {
    fun purchaseInteractor(): PurchaseInteractor
}