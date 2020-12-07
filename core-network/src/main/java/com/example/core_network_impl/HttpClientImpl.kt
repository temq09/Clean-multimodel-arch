package com.example.core_network_impl

import com.example.core_network_api.data.HttpClient
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class HttpClientImpl : HttpClient {
    override fun doAnyRequest(): Single<Any> {
        return Single.timer(300, TimeUnit.MILLISECONDS)
                .map { it + 100 }
                .map { Any() }
    }
}