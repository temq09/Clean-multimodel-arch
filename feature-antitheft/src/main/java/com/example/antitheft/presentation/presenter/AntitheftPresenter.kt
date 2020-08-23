package com.example.antitheft.presentation.presenter

import android.annotation.SuppressLint
import com.example.antitheft.domain.AntitheftInteractor
import com.example.antitheft.domain.models.AntitheftModel
import com.example.antitheft.presentation.view.AntitheftMainView
import com.example.antitheft.routing.AntitheftRoutingScreens
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
                                                      private val purchaseInteractor: PurchaseInteractor,
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
                .doOnSuccess { antitheftModel: PurchaseModel -> viewState.showBuySuccess() }
                .subscribe({ antitheftModel: PurchaseModel -> }) { throwable: Throwable -> }
    }

    fun clickToHelp() {
        router.navigateTo(AntitheftRoutingScreens.ANTITHEFT_HELP)
    }
}