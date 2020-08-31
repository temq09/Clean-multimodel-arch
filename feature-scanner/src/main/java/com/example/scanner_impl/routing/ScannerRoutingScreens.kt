package com.example.scanner_impl.routing

import com.example.scanner_impl.presentation.view.ScannerHelpFragment
import com.example.scanner_impl.presentation.view.ScannerMainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

internal object ScannerRoutingScreens {
    object SCANNER_MAIN : SupportAppScreen() {
        override fun getFragment() = ScannerMainFragment()
    }
    object SCANNER_HELP : SupportAppScreen() {
        override fun getFragment() = ScannerHelpFragment()
    }
}