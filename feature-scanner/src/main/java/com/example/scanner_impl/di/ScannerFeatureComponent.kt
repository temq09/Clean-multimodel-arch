package com.example.scanner_impl.di

import com.example.core.di.general.PerFeature
import com.example.scanner_api.ScannerFeatureApi
import com.example.scanner_impl.presentation.view.ScannerActivity
import com.example.scanner_impl.presentation.view.ScannerMainFragment
import dagger.Component

@Component(
        modules = [ScannerFeatureModule::class, ScreenNavigationModule::class],
        dependencies = [ScannerFeatureDependencies::class]
)
@PerFeature
internal abstract class ScannerFeatureComponent : ScannerFeatureApi {

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

