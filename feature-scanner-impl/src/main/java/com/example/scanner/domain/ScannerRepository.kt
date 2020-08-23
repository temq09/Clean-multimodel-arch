package com.example.scanner.domain

import com.example.scanner.domain.models.ScannerModel
import io.reactivex.Single

interface ScannerRepository {
    fun doScannerLowLevelWork(): Single<ScannerModel>
}