package com.example.purchase_impl.domain

import com.example.core.di.general.PerFeature
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@PerFeature
internal class PurchaseInteractorImpl @Inject constructor(private val purchaseRepository: PurchaseRepository) : com.example.purchase_api.domain.PurchaseInteractor {
    override fun makePurchase(): Single<com.example.purchase_api.domain.models.PurchaseModel> {
        return purchaseRepository.makePurchaseInStore()
                .flatMap { purchaseModel: com.example.purchase_api.domain.models.PurchaseModel -> doSomeLogic(purchaseModel) }
    }

    private fun doSomeLogic(purchaseModel: com.example.purchase_api.domain.models.PurchaseModel): Single<com.example.purchase_api.domain.models.PurchaseModel> {
        return Single.timer(3000, TimeUnit.MILLISECONDS)
                .map { aLong: Long -> purchaseModel }
    }
}