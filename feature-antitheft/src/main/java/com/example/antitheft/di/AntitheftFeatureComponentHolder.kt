package com.example.antitheft.di

import com.example.feature_antitheft_api.AntitheftFeatureApi
import com.example.module_injector.ComponentHolder

object AntitheftFeatureComponentHolder : ComponentHolder<AntitheftFeatureApi, AntitheftFeatureDependencies> {
    private var antitheftFeatureComponent: AntitheftFeatureComponent? = null

    override fun init(dependencies: AntitheftFeatureDependencies) {
        if (antitheftFeatureComponent == null) {
            synchronized(AntitheftFeatureComponentHolder::class.java) {
                if (antitheftFeatureComponent == null) {
                    antitheftFeatureComponent = AntitheftFeatureComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): AntitheftFeatureApi {
        checkNotNull(antitheftFeatureComponent) { "AntitheftFeatureComponent was not initialized!" }
        return antitheftFeatureComponent!!
    }

    internal fun getComponent(): AntitheftFeatureComponent {
        checkNotNull(antitheftFeatureComponent) { "AntitheftFeatureComponent was not initialized!" }
        return antitheftFeatureComponent!!
    }

    override fun reset() {
        antitheftFeatureComponent = null
    }

}