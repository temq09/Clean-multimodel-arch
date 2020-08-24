package com.example.scanner.di

import com.example.core.di.general.PerFeature
import com.example.feature_scanner_api.ScannerFeatureApi
import com.example.scanner.presentation.view.ScannerActivity
import com.example.scanner.presentation.view.ScannerMainFragment
import dagger.Component

@Component(
        modules = [ScannerFeatureModule::class, ScreenNavigationModule::class],
        dependencies = [ScannerFeatureDependencies::class]
)
@PerFeature
abstract class ScannerFeatureComponent : ScannerFeatureApi {

    internal abstract fun inject(scannerActivity: ScannerActivity)
    internal abstract fun inject(scannerMainFragment: ScannerMainFragment)

    companion object {
        fun initAndGet(scannerFeatureDependencies: ScannerFeatureDependencies): ScannerFeatureComponent {
            return DaggerScannerFeatureComponent.builder()
                    .scannerFeatureDependencies(scannerFeatureDependencies)
                    .build()

        }
    }
}

