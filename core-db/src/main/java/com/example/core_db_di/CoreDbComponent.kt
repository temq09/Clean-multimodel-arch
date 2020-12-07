package com.example.core_db_di

import dagger.Component
import javax.inject.Singleton

@Component(modules = [DbModule::class])
@Singleton
abstract class CoreDbComponent : CoreDbApi {
    companion object {
        @Volatile
        private var coreDbComponent: CoreDbComponent? = null

        fun get(): CoreDbComponent {
            if (coreDbComponent == null) {
                synchronized(CoreDbComponent::class.java) {
                    if (coreDbComponent == null) {
                        coreDbComponent = DaggerCoreDbComponent.builder().build()
                    }
                }
            }
            return coreDbComponent!!
        }
    }
}