package com.example.scanner.domain

import com.example.scanner.domain.models.ScannerModel
import io.reactivex.Single

interface ScannerInteractor {
    fun doScannerWork(): Single<ScannerModel>
}