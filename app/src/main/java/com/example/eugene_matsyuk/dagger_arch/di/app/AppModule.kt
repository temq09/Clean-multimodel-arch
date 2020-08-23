package com.example.eugene_matsyuk.dagger_arch.di.app

import android.content.Context
import com.example.eugene_matsyuk.dagger_arch.DaggerArchApplication
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
}