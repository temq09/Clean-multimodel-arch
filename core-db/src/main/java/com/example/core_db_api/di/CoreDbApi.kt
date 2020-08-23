package com.example.core_db_api.di

import com.example.core_db_api.data.DbClientApi
import com.example.module_injector.BaseAPI

interface CoreDbApi: BaseAPI {
    fun dbClientApi(): DbClientApi
}