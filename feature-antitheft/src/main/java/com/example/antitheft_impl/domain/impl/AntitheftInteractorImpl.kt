package com.example.antitheft_impl.domain.impl

import com.example.antitheft_impl.domain.api.AntitheftInteractor
import com.example.antitheft_impl.domain.api.AntitheftRepository
import com.example.antitheft_impl.domain.api.models.AntitheftModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit

internal class AntitheftInteractorImpl(private val antitheftRepository: AntitheftRepository) : AntitheftInteractor {
    override fun doAntitheftWork(): Single<AntitheftModel> {
        return antitheftRepository.doAntitheftLowLevelWork()
                .flatMap { antitheftModel: AntitheftModel -> doSomeLogic(antitheftModel) }
    }

    private fun doSomeLogic(antitheftModel: AntitheftModel): Single<AntitheftModel> {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
                .map { aLong: Long -> antitheftModel }
    }
}