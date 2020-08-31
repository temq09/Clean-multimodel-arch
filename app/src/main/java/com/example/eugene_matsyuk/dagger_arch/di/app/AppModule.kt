package com.example.eugene_matsyuk.dagger_arch.di.app

import android.content.Context
import com.example.antitheft_impl.di.AntitheftFeatureComponentHolder
import com.example.antitheft_impl.di.AntitheftFeatureDependencies
import com.example.core.di.app.CoreUtilsComponent
import com.example.core.utils.SomeUtils
import com.example.core_db_api.data.DbClientApi
import com.example.core_db_impl.di.CoreDbComponent
import com.example.core_network_api.data.HttpClientApi
import com.example.core_network_impl.di.CoreNetworkComponent
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
            override fun dbClient(): DbClientApi = CoreDbComponent.get().dbClientApi()

            override fun httpClient(): HttpClientApi = CoreNetworkComponent.get().httpClientApi()

            override fun someUtils(): SomeUtils = CoreUtilsComponent.get().someUtils()

            override fun purchaseInteractor(): PurchaseInteractor = featurePurchase.purchaseInteractor()

        }
    }

    @Singleton
    @Provides
    fun provideAntitheftFeatureDependencies(featurePurchase: PurchaseFeatureApi): AntitheftFeatureDependencies {
        return object : AntitheftFeatureDependencies {
            override fun dbClient(): DbClientApi = CoreDbComponent.get().dbClientApi()

            override fun httpClient(): HttpClientApi = CoreNetworkComponent.get().httpClientApi()

            override fun purchaseInteractor(): PurchaseInteractor = featurePurchase.purchaseInteractor()
        }
    }

    @Singleton
    @Provides
    fun providePurchaseFeatureDependencies(): PurchaseFeatureDependencies {
        return object : PurchaseFeatureDependencies {
            override fun httpClient(): HttpClientApi = CoreNetworkComponent.get().httpClientApi()
        }
    }

    @Singleton
    @Provides
    fun provideFeatureScanner(dependencies: ScannerFeatureDependencies): ScannerFeatureApi {
        ScannerFeatureComponentHolder.init(dependencies)
        return ScannerFeatureComponentHolder.get()
    }

    @Singleton
    @Provides
    fun provideFeatureAntitheft(dependencies: AntitheftFeatureDependencies): AntitheftFeatureApi {
        AntitheftFeatureComponentHolder.init(dependencies)
        return AntitheftFeatureComponentHolder.get()
    }

    @Singleton
    @Provides
    fun provideFeaturePurchase(dependencies: PurchaseFeatureDependencies): PurchaseFeatureApi {
        PurchaseComponentHolder.init(dependencies)
        return PurchaseComponentHolder.get()
    }
}