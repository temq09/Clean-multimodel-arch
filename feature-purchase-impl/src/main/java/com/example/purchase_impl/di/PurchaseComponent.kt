package com.example.purchase_impl.di

import com.example.core.di.general.PerFeature
import com.example.core_network_api.di.CoreNetworkApi
import com.example.purchase_api.di.PurchaseFeatureApi
import dagger.Component
import java.lang.ref.WeakReference

@Component(dependencies = [PurchaseFeatureDependencies::class], modules = [PurchaseModule::class])
@PerFeature
abstract class PurchaseComponent : PurchaseFeatureApi {

    @Component(dependencies = [CoreNetworkApi::class])
    @PerFeature
    interface PurchaseFeatureDependenciesComponent : PurchaseFeatureDependencies
    companion object {
        @Volatile
        private var purchaseComponentWeak: WeakReference<PurchaseComponent>? = null

        fun initAndGet(purchaseFeatureDependencies: PurchaseFeatureDependencies): PurchaseComponent {
            if (purchaseComponentWeak == null || purchaseComponentWeak!!.get() == null) {
                synchronized(PurchaseComponent::class.java) {
                    if (purchaseComponentWeak == null || purchaseComponentWeak!!.get() == null) {
                        val purchaseComponent = DaggerPurchaseComponent.builder()
                                .purchaseFeatureDependencies(purchaseFeatureDependencies)
                                .build()
                        purchaseComponentWeak = WeakReference(purchaseComponent)
                    }
                }
            }
            return purchaseComponentWeak!!.get()!!
        }
    }
}