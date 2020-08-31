package com.example.antitheft_api

import com.example.module_injector.BaseAPI

interface AntitheftFeatureApi: BaseAPI {
    fun antitheftStarter(): AntitheftStarter
}