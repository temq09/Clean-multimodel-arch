package com.example.feature_scanner_api

import com.example.module_injector.BaseAPI

interface ScannerFeatureApi : BaseAPI {
    fun scannerStarter(): ScannerStarter
}