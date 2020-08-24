package com.example.eugene_matsyuk.dagger_arch.di.app

import android.content.Context
import com.example.core.di.app.CoreUtilsComponent
import com.example.core.utils.SomeUtils
import com.example.core_db_api.data.DbClientApi
import com.example.core_db_impl.di.CoreDbComponent
import com.example.core_network_api.data.HttpClientApi
import com.example.core_network_impl.di.CoreNetworkComponent
import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication
import com.example.feature_scanner_api.ScannerFeatureApi
import com.example.purchase_api.di.PurchaseFeatureApi
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_impl.di.DaggerPurchaseComponent_PurchaseFeatureDependenciesComponent
import com.example.purchase_impl.di.PurchaseComponent
import com.example.scanner.di.ScannerFeatureComponentHolder
import com.example.scanner.di.ScannerFeatureDependencies
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
    fun provideScannerFeatureDependencies(): ScannerFeatureDependencies {
        return object : ScannerFeatureDependencies {
            override fun dbClient(): DbClientApi = CoreDbComponent.get().dbClientApi()

            override fun httpClient(): HttpClientApi = CoreNetworkComponent.get().httpClientApi()

            override fun someUtils(): SomeUtils = CoreUtilsComponent.get().someUtils()

            override fun purchaseInteractor(): PurchaseInteractor = featurePurchaseGet().purchaseInteractor()

        }
    }

    private fun featurePurchaseGet(): PurchaseFeatureApi {
        return PurchaseComponent.initAndGet(
                DaggerPurchaseComponent_PurchaseFeatureDependenciesComponent.builder()
                        .coreNetworkApi(CoreNetworkComponent.get())
                        .build()
        )
    }

    @Singleton
    @Provides
    fun provideFeatureScanner(dependencies: ScannerFeatureDependencies): ScannerFeatureApi {
        ScannerFeatureComponentHolder.init(dependencies)
        return ScannerFeatureComponentHolder.get()
    }
}