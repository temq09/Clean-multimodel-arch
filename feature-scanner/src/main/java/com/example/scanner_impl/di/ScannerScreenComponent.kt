package com.example.scanner_impl.di

import com.example.core.di.general.PerScreen
import com.example.scanner_impl.presentation.presenter.ScannerPresenter
import dagger.Subcomponent

@Subcomponent
@PerScreen
internal interface ScannerScreenComponent {
    fun scannerPresenter(): ScannerPresenter
}