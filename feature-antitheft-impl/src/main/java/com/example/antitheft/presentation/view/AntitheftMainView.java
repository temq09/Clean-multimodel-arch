package com.example.antitheft.presentation.view;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

public interface AntitheftMainView extends MvpView {

    @StateStrategyType(OneExecutionStateStrategy.class)
    void showAtWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showAtSuccess();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuyWork();
    @StateStrategyType(OneExecutionStateStrategy.class)
    void showBuySuccess();

}
