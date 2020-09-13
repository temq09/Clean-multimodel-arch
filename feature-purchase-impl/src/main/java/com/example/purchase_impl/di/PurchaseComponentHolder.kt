package com.example.purchase_impl.di

import android.util.Log
import com.example.module_injector.ComponentHolder
import com.example.purchase_api.PurchaseFeatureApi

object PurchaseComponentHolder : ComponentHolder<PurchaseFeatureApi, PurchaseFeatureDependencies> {
    private var purchaseComponentHolder: PurchaseComponent? = null

    override fun init(dependencies: PurchaseFeatureDependencies) {
        Log.i("PurchaseCH", "init()")
        if (purchaseComponentHolder == null) {
            synchronized(PurchaseComponentHolder::class.java) {
                if (purchaseComponentHolder == null) {
                    Log.i("PurchaseCH", "initAndGet()")
                    purchaseComponentHolder = PurchaseComponent.initAndGet(dependencies)
                }
            }
        }
    }

    override fun get(): PurchaseFeatureApi {
        checkNotNull(purchaseComponentHolder) { "PurchaseComponent was not initialized!" }
        return purchaseComponentHolder!!
    }

    override fun reset() {
        Log.i("PurchaseCH", "reset()")
        purchaseComponentHolder = null
    }

}