package com.example.antitheft_di

import android.util.Log
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.module_injector.ComponentHolder

object AntitheftFeatureComponentHolder : ComponentHolder<AntitheftFeatureApi, AntitheftFeatureDependencies> {
    private var antitheftFeatureComponent: AntitheftFeatureComponent? = null

    override fun init(dependencies: AntitheftFeatureDependencies) {
        Log.i("AntitheftFeatureCH", "init()")
        if (antitheftFeatureComponent == null) {
            synchronized(AntitheftFeatureComponentHolder::class.java) {
                if (antitheftFeatureComponent == null) {
                    Log.i("AntitheftFeatureCH", "initAndGet()")
                    antitheftFeatureComponent = AntitheftFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): AntitheftFeatureApi = getComponent()

    internal fun getComponent(): AntitheftFeatureComponent {
        checkNotNull(antitheftFeatureComponent) { "AntitheftFeatureComponent was not initialized!" }
        return antitheftFeatureComponent!!
    }

    override fun reset() {
        Log.i("AntitheftFeatureCH", "reset()")
        antitheftFeatureComponent = null
    }

}