package com.example.eugene_matsyuk.dagger_arch.di.app

import android.content.Context
import com.example.antitheft_di.AntitheftFeatureComponentHolder
import com.example.antitheft_di.AntitheftFeatureDependencies
import com.example.core.di.app.CoreUtilsComponent
import com.example.core.utils.SomeUtils
import com.example.core_db_api.DbClient
import com.example.core_db_di.CoreDbComponent
import com.example.core_network_api.data.HttpClient
import com.example.core_network_di.CoreNetworkComponent
import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication
import com.example.antitheft_api.AntitheftFeatureApi
import com.example.scanner_api.ScannerFeatureApi
import com.example.purchase_api.PurchaseFeatureApi
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_impl.di.PurchaseComponentHolder
import com.example.purchase_impl.di.PurchaseFeatureDependencies
import com.example.scanner_impl.di.ScannerFeatureComponentHolder
import com.example.scanner_impl.di.ScannerFeatureDependencies
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Singleton
    @Provides
    fun provideContext(): Context {
        return DaggerArchApplication.appContext
    }

    @Singleton
    @Provides
    fun provideScannerFeatureDependencies(featurePurchase: PurchaseFeatureApi): ScannerFeatureDependencies {
        return object : ScannerFeatureDependencies {
            override fun dbClient(): DbClient = CoreDbComponent.get().dbClient()

            override fun httpClient(): HttpClient = CoreNetworkComponent.get().httpClient()

            override fun someUtils(): SomeUtils = CoreUtilsComponent.get().someUtils()

            override fun purchaseInteractor(): PurchaseInteractor = featurePurchase.purchaseInteractor()

        }
    }

    @Singleton
    @Provides
    fun provideAntitheftFeatureDependencies(featurePurchase: PurchaseFeatureApi): AntitheftFeatureDependencies {
        return object : AntitheftFeatureDependencies {
            override fun dbClient(): DbClient = CoreDbComponent.get().dbClient()

            override fun httpClient(): HttpClient = CoreNetworkComponent.get().httpClient()

            override fun purchaseInteractor(): PurchaseInteractor = featurePurchase.purchaseInteractor()
        }
    }

    @Singleton
    @Provides
    fun providePurchaseFeatureDependencies(): PurchaseFeatureDependencies {
        return object : PurchaseFeatureDependencies {
            override fun httpClient(): HttpClient = CoreNetworkComponent.get().httpClient()
        }
    }

    @Provides
    fun provideFeatureScanner(dependencies: ScannerFeatureDependencies): ScannerFeatureApi {
        ScannerFeatureComponentHolder.init(dependencies)
        return ScannerFeatureComponentHolder.get()
    }

    @Provides
    fun provideFeatureAntitheft(dependencies: AntitheftFeatureDependencies): AntitheftFeatureApi {
        AntitheftFeatureComponentHolder.init(dependencies)
        return AntitheftFeatureComponentHolder.get()
    }

    @Provides
    fun provideFeaturePurchase(dependencies: PurchaseFeatureDependencies): PurchaseFeatureApi {
        PurchaseComponentHolder.init(dependencies)
        return PurchaseComponentHolder.get()
    }
}