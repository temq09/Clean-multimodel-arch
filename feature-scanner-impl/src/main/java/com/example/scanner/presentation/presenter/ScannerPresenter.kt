package com.example.scanner.presentation.presenter

import android.annotation.SuppressLint
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import com.example.scanner.domain.ScannerInteractor
import com.example.scanner.domain.models.ScannerModel
import com.example.scanner.presentation.view.ScannerMainView
import com.example.scanner.routing.ScannerRoutingScreens.SCANNER_HELP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class ScannerPresenter @Inject constructor(private val mScannerInteractor: ScannerInteractor,
                                           private val mPurchaseInteractor: PurchaseInteractor,
                                           private val mRouter: Router) : MvpPresenter<ScannerMainView>() {
    @SuppressLint("CheckResult")
    fun clickToScannerWork() {
        mScannerInteractor.doScannerWork()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable: Disposable -> viewState.showScannerWork() }
                .doOnSuccess { antitheftModel: ScannerModel -> viewState.showScannerSuccess() }
                .subscribe({ antitheftModel: ScannerModel -> }) { throwable: Throwable -> }
    }

    @SuppressLint("CheckResult")
    fun clickToBuyWork() {
        mPurchaseInteractor.makePurchase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable: Disposable -> viewState.showBuyWork() }
                .doOnSuccess { antitheftModel: PurchaseModel -> viewState.showBuySuccess() }
                .subscribe({ antitheftModel: PurchaseModel -> }, { throwable: Throwable -> })
    }

    fun clickToHelp() {
        mRouter.navigateTo(SCANNER_HELP)
    }
}