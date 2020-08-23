package com.example.scanner.di

import com.example.core.di.app.CoreUtilsApi
import com.example.core.di.general.PerFeature
import com.example.core_db_api.di.CoreDbApi
import com.example.core_network_api.di.CoreNetworkApi
import com.example.feature_scanner_api.ScannerFeatureApi
import com.example.purchase_api.di.PurchaseFeatureApi
import com.example.scanner.presentation.view.ScannerActivity
import dagger.Component

@Component(modules = [ScannerFeatureModule::class, ScreenNavigationModule::class], dependencies = [ScannerFeatureDependencies::class])
@PerFeature
abstract class ScannerFeatureComponent : ScannerFeatureApi {

    fun resetComponent() {
        scannerFeatureComponent = null
    }

    internal abstract fun inject(scannerActivity: ScannerActivity)
    internal abstract fun scannerScreenComponent(): ScannerScreenComponent

    @Component(dependencies = [CoreUtilsApi::class, CoreNetworkApi::class, CoreDbApi::class, PurchaseFeatureApi::class])
    @PerFeature
    internal interface ScannerFeatureDependenciesComponent : ScannerFeatureDependencies

    companion object {
        @Volatile
        private var scannerFeatureComponent: ScannerFeatureComponent? = null

        fun initAndGet(scannerFeatureDependencies: ScannerFeatureDependencies): ScannerFeatureApi {
            if (scannerFeatureComponent == null) {
                synchronized(ScannerFeatureComponent::class.java) {
                    if (scannerFeatureComponent == null) {
                        scannerFeatureComponent = DaggerScannerFeatureComponent.builder()
                                .scannerFeatureDependencies(scannerFeatureDependencies)
                                .build()
                    }
                }
            }
            return scannerFeatureComponent!!
        }

        fun get(): ScannerFeatureComponent {
            if (scannerFeatureComponent == null) {
                throw RuntimeException("You must call 'initAndGet(ScannerFeatureDependenciesComponent scannerFeatureDependenciesComponent)' method")
            }
            return scannerFeatureComponent!!
        }
    }
}