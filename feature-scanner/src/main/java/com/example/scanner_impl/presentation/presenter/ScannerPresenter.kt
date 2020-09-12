package com.example.scanner_impl.presentation.presenter

import android.annotation.SuppressLint
import com.example.purchase_api.domain.PurchaseInteractor
import com.example.purchase_api.domain.models.PurchaseModel
import com.example.scanner_impl.domain.ScannerInteractor
import com.example.scanner_impl.domain.models.ScannerModel
import com.example.scanner_impl.presentation.view.ScannerMainView
import com.example.scanner_impl.routing.ScannerRoutingScreens.SCANNER_HELP
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import moxy.InjectViewState
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
internal class ScannerPresenter @Inject constructor(private val scannerInteractor: ScannerInteractor,
                                                    private val purchaseInteractor: com.example.purchase_api.domain.PurchaseInteractor,
                                                    private val router: Router) : MvpPresenter<ScannerMainView>() {
    @SuppressLint("CheckResult")
    fun clickToScannerWork() {
        scannerInteractor.doScannerWork()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable: Disposable -> viewState.showScannerWork() }
                .doOnSuccess { antitheftModel: ScannerModel -> viewState.showScannerSuccess() }
                .subscribe({ antitheftModel: ScannerModel -> }) { throwable: Throwable -> }
    }

    @SuppressLint("CheckResult")
    fun clickToBuyWork() {
        purchaseInteractor.makePurchase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { disposable: Disposable -> viewState.showBuyWork() }
                .doOnSuccess { antitheftModel: com.example.purchase_api.domain.models.PurchaseModel -> viewState.showBuySuccess() }
                .subscribe({ antitheftModel: com.example.purchase_api.domain.models.PurchaseModel -> }, { throwable: Throwable -> })
    }

    fun clickToHelp() {
        router.navigateTo(SCANNER_HELP)
    }
}