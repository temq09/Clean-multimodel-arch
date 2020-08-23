package com.example.eugene_matsyuk.dagger_arch.di.app

import com.example.eugene_matsyuk.dagger_arch.di.DiConstants.GLOBAL
import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import javax.inject.Named
import javax.inject.Singleton

@Module
class GlobalNavigationModule {
    private val cicerone: Cicerone<Router> = Cicerone.create()

    @Singleton
    @Provides
    @Named(GLOBAL)
    fun provideRouter(): Router {
        return cicerone.router
    }

    @Singleton
    @Provides
    @Named(GLOBAL)
    fun provideNavigatorHolder(): NavigatorHolder {
        return cicerone.navigatorHolder
    }

}