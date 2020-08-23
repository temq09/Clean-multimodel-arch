package com.example.purchase_impl.di

import com.example.core.di.general.PerFeature
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_impl.data.PurchaseRepositoryImpl
import com.example.purchase_impl.domain.PurchaseInteractorImpl
import com.example.purchase_impl.domain.PurchaseRepository
import dagger.Binds
import dagger.Module

@Module
abstract class PurchaseModule {
    @PerFeature
    @Binds
    abstract fun providePurchaseRepository(purchaseRepository: PurchaseRepositoryImpl): PurchaseRepository
    @PerFeature
    @Binds
    abstract fun providePurchaseInteractor(purchaseInteractor: PurchaseInteractorImpl): PurchaseInteractor
}