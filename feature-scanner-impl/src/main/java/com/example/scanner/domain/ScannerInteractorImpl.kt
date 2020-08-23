package com.example.scanner.domain

import com.example.core.di.general.PerFeature
import com.example.scanner.domain.models.ScannerModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@PerFeature
class ScannerInteractorImpl @Inject constructor(private val mScannerRepository: ScannerRepository) : ScannerInteractor {
    override fun doScannerWork(): Single<ScannerModel> {
        return mScannerRepository.doScannerLowLevelWork()
                .flatMap { scannerModel: ScannerModel -> doSomeLogic(scannerModel) }
    }

    private fun doSomeLogic(scannerModel: ScannerModel): Single<ScannerModel> {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
                .map { aLong: Long -> scannerModel }
    }
}