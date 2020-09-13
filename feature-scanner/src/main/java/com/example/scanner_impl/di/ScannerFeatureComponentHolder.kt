package com.example.scanner_impl.di

import android.util.Log
import com.example.scanner_api.ScannerFeatureApi
import com.example.module_injector.ComponentHolder

object ScannerFeatureComponentHolder : ComponentHolder<ScannerFeatureApi, ScannerFeatureDependencies> {
    private var scannerFeatureComponent: ScannerFeatureComponent? = null

    override fun init(dependencies: ScannerFeatureDependencies) {
        Log.i("ScannerFeatureCH", "init()")
        if (scannerFeatureComponent == null) {
            synchronized(ScannerFeatureComponentHolder::class.java) {
                if (scannerFeatureComponent == null) {
                    Log.i("ScannerFeatureCH", "initAndGet()")
                    scannerFeatureComponent = ScannerFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): ScannerFeatureApi = getComponent()

    internal fun getComponent(): ScannerFeatureComponent {
        checkNotNull(scannerFeatureComponent) { "ScannerFeatureComponent was not initialized!" }
        return scannerFeatureComponent!!
    }

    override fun reset() {
        Log.i("ScannerFeatureCH", "reset()")
        scannerFeatureComponent = null
    }

}