package com.example.antitheft.di

import com.example.antitheft.presentation.view.AntitheftActivity
import com.example.core.di.app.CoreUtilsApi
import com.example.core.di.general.PerFeature
import com.example.core_db_api.di.CoreDbApi
import com.example.core_network_api.di.CoreNetworkApi
import com.example.feature_antitheft_api.AntitheftFeatureApi
import com.example.purchase_api.di.PurchaseFeatureApi
import dagger.Component

@Component(modules = [AntitheftFeatureModule::class, AntitheftNavigationModule::class], dependencies = [AntitheftFeatureDependencies::class])
@PerFeature
abstract class AntitheftFeatureComponent : AntitheftFeatureApi {

    fun resetComponent() {
        antitheftFeatureComponent = null
    }

    abstract fun inject(antitheftActivity: AntitheftActivity)
    abstract fun antitheftScreenComponent(): AntitheftScreenComponent

    @Component(dependencies = [CoreUtilsApi::class, CoreNetworkApi::class, CoreDbApi::class, PurchaseFeatureApi::class])
    @PerFeature
    interface AntitheftFeatureDependenciesComponent : AntitheftFeatureDependencies

    companion object {
        @Volatile
        private var antitheftFeatureComponent: AntitheftFeatureComponent? = null

        fun initAndGet(antitheftFeatureDependencies: AntitheftFeatureDependencies): AntitheftFeatureApi {
            if (antitheftFeatureComponent == null) {
                synchronized(AntitheftFeatureComponent::class.java) {
                    if (antitheftFeatureComponent == null) {
                        antitheftFeatureComponent = DaggerAntitheftFeatureComponent.builder()
                                .antitheftFeatureDependencies(antitheftFeatureDependencies)
                                .build()
                    }
                }
            }
            return antitheftFeatureComponent!!
        }

        fun get(): AntitheftFeatureComponent {
            if (antitheftFeatureComponent == null) {
                throw RuntimeException("You must call 'initAndGet(AntitheftFeatureDependencies antitheftFeatureDependencies)' method")
            }
            return antitheftFeatureComponent!!
        }
    }
}