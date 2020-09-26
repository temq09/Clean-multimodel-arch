package com.example.core_network_api.data

import io.reactivex.Single

interface HttpClient {
    fun doAnyRequest(): Single<Any>
}