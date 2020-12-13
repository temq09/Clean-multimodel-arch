package com.example.antitheft_di

import com.example.antitheft_impl.presentation.view.AntitheftActivity
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import com.example.core.di.general.PerFeature
import com.example.antitheft_api.AntitheftFeatureApi
import dagger.Component

@Component(
        modules = [AntitheftFeatureModule::class, AntitheftNavigationModule::class],
        dependencies = [AntitheftFeatureDependencies::class]
)
@PerFeature
internal abstract class AntitheftFeatureComponent : AntitheftFeatureApi {

    internal abstract fun inject(antitheftActivity: AntitheftActivity)
    internal abstract fun inject(antitheftMainFragment: AntitheftMainFragment)

    companion object {

        fun initAndGet(antitheftFeatureDependencies: AntitheftFeatureDependencies): AntitheftFeatureComponent {
            return DaggerAntitheftFeatureComponent.builder()
                    .antitheftFeatureDependencies(antitheftFeatureDependencies)
                    .build()

        }
    }
}

