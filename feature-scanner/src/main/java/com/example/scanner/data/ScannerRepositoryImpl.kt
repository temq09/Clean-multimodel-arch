package com.example.scanner.data

import com.example.core.di.general.PerFeature
import com.example.core.utils.SomeUtils
import com.example.core_db_api.data.DbClientApi
import com.example.core_network_api.data.HttpClientApi
import com.example.scanner.domain.ScannerRepository
import com.example.scanner.domain.models.ScannerModel
import io.reactivex.Single
import io.reactivex.functions.Function
import javax.inject.Inject

@PerFeature
internal class ScannerRepositoryImpl @Inject constructor(
        private val httpClient: HttpClientApi,
        private val dbClient: DbClientApi,
        private val someUtils: SomeUtils
) : ScannerRepository {
    override fun doScannerLowLevelWork(): Single<ScannerModel> {
        return httpClient.doAnyRequest()
                .map { o: Any -> ScannerModel() }
    }
}