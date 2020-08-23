package com.example.scanner.domain

import com.example.scanner.domain.models.ScannerModel
import io.reactivex.Single

internal interface ScannerRepository {
    fun doScannerLowLevelWork(): Single<ScannerModel>
}