package com.example.antitheft_impl.di

import com.example.antitheft_api.AntitheftFeatureApi
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

    override fun get(): AntitheftFeatureApi = getComponent()

    internal fun getComponent(): AntitheftFeatureComponent {
        checkNotNull(antitheftFeatureComponent) { "AntitheftFeatureComponent was not initialized!" }
        return antitheftFeatureComponent!!
    }

    override fun reset() {
        antitheftFeatureComponent = null
    }

}