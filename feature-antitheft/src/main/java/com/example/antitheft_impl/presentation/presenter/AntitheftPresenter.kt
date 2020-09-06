package com.example.antitheft_impl.presentation.presenter

import android.annotation.SuppressLint
import com.example.antitheft_impl.domain.AntitheftInteractor
import com.example.antitheft_impl.domain.models.AntitheftModel
import com.example.antitheft_impl.presentation.view.AntitheftMainView
import com.example.antitheft_impl.routing.AntitheftRoutingScreens
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class AntitheftPresenter @Inject constructor(private val antitheftInteractor: AntitheftInteractor,
                                                      private val purchaseInteractor: com.example.purchase_api.domain.PurchaseInteractor,
                                                      private val router: Router) : MvpPresenter<AntitheftMainView>() {
    @SuppressLint("CheckResult")
    fun clickToAtWork() {
        antitheftInteractor.doAntitheftWork()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { viewState.showAtWork() }
                .doOnSuccess { antitheftModel: AntitheftModel -> viewState.showAtSuccess() }
                .subscribe({ antitheftModel: AntitheftModel -> }, { throwable: Throwable -> })
    }

    @SuppressLint("CheckResult")
    fun clickToBuyWork() {
        purchaseInteractor.makePurchase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable: Disposable -> viewState.showBuyWork() }
                .doOnSuccess { antitheftModel: com.example.purchase_api.domain.models.PurchaseModel -> viewState.showBuySuccess() }
                .subscribe({ antitheftModel: com.example.purchase_api.domain.models.PurchaseModel -> }) { throwable: Throwable -> }
    }

    fun clickToHelp() {
        router.navigateTo(AntitheftRoutingScreens.ANTITHEFT_HELP)
    }
}