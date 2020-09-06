package com.example.scanner_example.fake

import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class PurchaseInteractorFake : com.example.purchase_api.domain.PurchaseInteractor {
    override fun makePurchase(): Single<com.example.purchase_api.domain.models.PurchaseModel> {
        return Single.timer(100, TimeUnit.MILLISECONDS)
                .map { aLong: Long -> com.example.purchase_api.domain.models.PurchaseModel() }
    }
}