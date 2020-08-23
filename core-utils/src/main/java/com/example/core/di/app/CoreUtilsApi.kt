package com.example.core.di.app

import com.example.core.utils.SomeUtils
import com.example.module_injector.BaseAPI

interface CoreUtilsApi : BaseAPI {
    fun someUtils(): SomeUtils
}