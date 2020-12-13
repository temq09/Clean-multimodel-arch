package com.example.antitheft_impl.repositories_impl

import com.example.antitheft_impl.domain.api.AntitheftRepository
import com.example.antitheft_impl.domain.api.models.AntitheftModel
import com.example.core_db_api.DbClient
import com.example.core_network_api.data.HttpClient
import io.reactivex.Single

internal class AntitheftRepositoryImpl(
        private val httpClient: HttpClient,
        private val dbClient: DbClient
) : AntitheftRepository {
    override fun doAntitheftLowLevelWork(): Single<AntitheftModel> {
        return httpClient.doAnyRequest()
                .map { AntitheftModel() }
    }
}