package com.example.scanner.domain

import com.example.scanner.domain.models.ScannerModel
import io.reactivex.Single

internal interface ScannerInteractor {
    fun doScannerWork(): Single<ScannerModel>
}