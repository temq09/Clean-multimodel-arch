package com.example.antitheft_di

import com.example.antitheft_api.AntitheftFeatureApi
import com.example.antitheft_impl.presentation.view.AntitheftActivity
import com.example.antitheft_impl.presentation.view.AntitheftMainFragment
import com.example.core.di.general.PerFeature
import dagger.Component

@Component(
        modules = [AntitheftFeatureModule::class, AntitheftNavigationModule::class],
        dependencies = [AntitheftFeatureDependencies::class]
)
@PerFeature
internal interface AntitheftFeatureComponent : AntitheftFeatureApi {

    fun inject(antitheftActivity: AntitheftActivity)
    fun inject(antitheftMainFragment: AntitheftMainFragment)

}

