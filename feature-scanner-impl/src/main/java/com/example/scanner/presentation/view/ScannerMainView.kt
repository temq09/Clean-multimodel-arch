package com.example.scanner.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
internal interface ScannerMainView : MvpView {
    fun showScannerWork()

    fun showScannerSuccess()

    fun showBuyWork()

    fun showBuySuccess()
}