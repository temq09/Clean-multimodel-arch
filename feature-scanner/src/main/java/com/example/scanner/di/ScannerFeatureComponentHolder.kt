package com.example.scanner.di

import com.example.feature_scanner_api.ScannerFeatureApi
import com.example.module_injector.ComponentHolder

object ScannerFeatureComponentHolder : ComponentHolder<ScannerFeatureApi, ScannerFeatureDependencies> {
    private var scannerFeatureComponent: ScannerFeatureComponent? = null

    override fun init(dependencies: ScannerFeatureDependencies) {
        if (scannerFeatureComponent == null) {
            synchronized(ScannerFeatureComponentHolder::class.java) {
                if (scannerFeatureComponent == null) {
                    scannerFeatureComponent = ScannerFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ScannerFeatureApi {
        checkNotNull(scannerFeatureComponent) { "ScannerFeatureComponent was not initialized!" }
        return scannerFeatureComponent!!
    }

    internal fun getComponent(): ScannerFeatureComponent {
        checkNotNull(scannerFeatureComponent) { "ScannerFeatureComponent was not initialized!" }
        return scannerFeatureComponent!!
    }

    override fun reset() {
        scannerFeatureComponent = null
    }

}