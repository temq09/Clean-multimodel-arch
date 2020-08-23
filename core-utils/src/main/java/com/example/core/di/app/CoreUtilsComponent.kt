package com.example.core.di.app

import dagger.Component
import javax.inject.Singleton

@Component
@Singleton
abstract class CoreUtilsComponent : CoreUtilsApi {
    companion object {
        @Volatile
        private var coreUtilsComponent: CoreUtilsComponent? = null

        fun get(): CoreUtilsComponent {
            if (coreUtilsComponent == null) {
                synchronized(CoreUtilsComponent::class.java) {
                    if (coreUtilsComponent == null) {
                        coreUtilsComponent = DaggerCoreUtilsComponent.builder().build()
                    }
                }
            }
            return coreUtilsComponent!!
        }
    }
}