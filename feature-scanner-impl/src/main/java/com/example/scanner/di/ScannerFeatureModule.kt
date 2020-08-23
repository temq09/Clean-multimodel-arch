package com.example.scanner.di

import com.example.core.di.general.PerFeature
import com.example.feature_scanner_api.ScannerStarter
import com.example.scanner.data.ScannerRepositoryImpl
import com.example.scanner.domain.ScannerInteractor
import com.example.scanner.domain.ScannerInteractorImpl
import com.example.scanner.domain.ScannerRepository
import com.example.scanner.start.ScannerStarterImpl
import dagger.Binds
import dagger.Module

@Module
internal abstract class ScannerFeatureModule {
    @PerFeature
    @Binds
    abstract fun provideScannerRepository(scannerRepository: ScannerRepositoryImpl): ScannerRepository
    @PerFeature
    @Binds
    abstract fun provideScannerInteractor(scannerInteractor: ScannerInteractorImpl): ScannerInteractor
    @PerFeature
    @Binds
    abstract fun provideScannerStarter(scannerStarter: ScannerStarterImpl): ScannerStarter
}