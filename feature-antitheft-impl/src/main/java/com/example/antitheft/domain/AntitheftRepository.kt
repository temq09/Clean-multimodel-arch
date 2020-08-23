package com.example.antitheft.domain

import com.example.antitheft.domain.models.AntitheftModel
import io.reactivex.Single

interface AntitheftRepository {
    fun doAntitheftLowLevelWork(): Single<AntitheftModel>
}