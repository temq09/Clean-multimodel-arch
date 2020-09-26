package com.example.scanner_example.fake

import com.example.core_network_api.data.HttpClient
import io.reactivex.Single
import javax.inject.Inject

class HttpClientFake @Inject constructor() : HttpClient {
    override fun doAnyRequest(): Single<Any> {
        return Single.just(Any())
    }
}