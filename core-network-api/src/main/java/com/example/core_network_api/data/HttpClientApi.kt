package com.example.core_network_api.data

import io.reactivex.Single

interface HttpClientApi {
    fun doAnyRequest(): Single<Any>
}