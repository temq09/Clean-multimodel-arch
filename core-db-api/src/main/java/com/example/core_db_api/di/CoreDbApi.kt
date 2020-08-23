package com.example.core_db_api.di

import com.example.core_db_api.data.DbClientApi

interface CoreDbApi {
    fun dbClientApi(): DbClientApi
}