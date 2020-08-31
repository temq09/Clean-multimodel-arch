package com.example.antitheft_impl.repositories_impl

import com.example.antitheft_impl.domain.AntitheftRepository
import com.example.antitheft_impl.domain.models.AntitheftModel
import com.example.core.di.general.PerFeature
import com.example.core_db_api.data.DbClientApi
import com.example.core_network_api.data.HttpClientApi
import io.reactivex.Single
import javax.inject.Inject

@PerFeature
internal class AntitheftRepositoryImpl @Inject constructor(
        private val httpClient: HttpClientApi,
        private val dbClient: DbClientApi
) : AntitheftRepository {
    override fun doAntitheftLowLevelWork(): Single<AntitheftModel> {
        return httpClient.doAnyRequest()
                .map { o: Any -> AntitheftModel() }
    }
}