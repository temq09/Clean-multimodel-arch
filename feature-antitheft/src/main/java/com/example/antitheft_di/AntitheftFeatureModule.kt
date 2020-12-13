package com.example.antitheft_di

import com.example.antitheft_api.AntitheftStarter
import com.example.antitheft_impl.domain.api.AntitheftInteractor
import com.example.antitheft_impl.domain.api.AntitheftRepository
import com.example.antitheft_impl.domain.impl.AntitheftInteractorImpl
import com.example.antitheft_impl.repositories_impl.AntitheftRepositoryImpl
import com.example.antitheft_impl.presentation.start.AntitheftStarterImpl
import com.example.core.di.general.PerFeature
import com.example.core_db_api.DbClient
import com.example.core_network_api.data.HttpClient
import dagger.Module
import dagger.Provides

@Module
internal object AntitheftFeatureModule {
    @PerFeature
    @Provides
    fun provideAntitheftRepository(httpClient: HttpClient, dbClient: DbClient): AntitheftRepository =
            AntitheftRepositoryImpl(httpClient, dbClient)

    @PerFeature
    @Provides
    fun provideAntitheftInteractor(repo: AntitheftRepository): AntitheftInteractor =
            AntitheftInteractorImpl(repo)

    @PerFeature
    @Provides
    fun provideAntitheftStarter(): AntitheftStarter =
            AntitheftStarterImpl()
}