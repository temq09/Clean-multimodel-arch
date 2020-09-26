package com.example.core_db_api.di

import com.example.core_db_api.data.DbClient
import com.example.module_injector.BaseAPI

interface CoreDbApi: BaseAPI {
    fun dbClient(): DbClient
}