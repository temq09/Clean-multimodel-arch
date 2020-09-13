package com.example.purchase_impl.di

import com.example.core.di.general.PerFeature
import com.example.purchase_api.PurchaseFeatureApi
import dagger.Component

@Component(dependencies = [PurchaseFeatureDependencies::class], modules = [PurchaseModule::class])
@PerFeature
internal abstract class PurchaseComponent : PurchaseFeatureApi {

    companion object {
        fun initAndGet(purchaseFeatureDependencies: PurchaseFeatureDependencies): PurchaseComponent {
            return DaggerPurchaseComponent.builder()
                    .purchaseFeatureDependencies(purchaseFeatureDependencies)
                    .build()
        }
    }
}

