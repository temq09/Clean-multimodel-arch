package com.example.scanner_impl.domain

import com.example.scanner_impl.domain.models.ScannerModel
import io.reactivex.Single

internal interface ScannerRepository {
    fun doScannerLowLevelWork(): Single<ScannerModel>
}