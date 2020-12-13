package com.example.antitheft_impl.domain.api

import com.example.antitheft_impl.domain.api.models.AntitheftModel
import io.reactivex.Single

interface AntitheftInteractor {
    fun doAntitheftWork(): Single<AntitheftModel>
}