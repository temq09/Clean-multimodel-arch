package com.example.scanner.presentation.view;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface ScannerMainView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showScannerWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showScannerSuccess();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuyWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuySuccess();

}
