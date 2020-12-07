package com.example.core_db_di

import com.example.core_db_api.DbClient
import com.example.core_db_impl.DbClientImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal object DbModule {
    @Singleton
    @Provides
    fun provideDbClientApi(): DbClient =
            DbClientImpl()
}