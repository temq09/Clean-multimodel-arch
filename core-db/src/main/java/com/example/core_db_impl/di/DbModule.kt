package com.example.core_db_impl.di

import com.example.core_db_api.data.DbClient
import com.example.core_db_impl.data.DbClientImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal abstract class DbModule {
    @Singleton
    @Binds
    abstract fun provideDbClientApi(dbClientImpl: DbClientImpl): DbClient
}