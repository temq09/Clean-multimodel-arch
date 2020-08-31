package com.example.scanner_impl.domain

import com.example.scanner_impl.domain.models.ScannerModel
import io.reactivex.Single

internal interface ScannerInteractor {
    fun doScannerWork(): Single<ScannerModel>
}