package com.example.antitheft.presentation.view

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.OneExecution

@OneExecution
interface AntitheftMainView : MvpView {

    fun showAtWork()

    fun showAtSuccess()

    fun showBuyWork()

    fun showBuySuccess()
}