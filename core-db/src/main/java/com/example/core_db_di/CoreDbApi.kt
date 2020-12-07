package com.example.core_db_di

import com.example.core_db_api.DbClient
import com.example.module_injector.BaseAPI

interface CoreDbApi: BaseAPI {
    fun dbClient(): DbClient
}