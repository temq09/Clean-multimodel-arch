package com.example.scanner.routing

import com.example.scanner.presentation.view.ScannerHelpFragment
import com.example.scanner.presentation.view.ScannerMainFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

internal object ScannerRoutingScreens {
    object SCANNER_MAIN : SupportAppScreen() {
        override fun getFragment() = ScannerMainFragment()
    }
    object SCANNER_HELP : SupportAppScreen() {
        override fun getFragment() = ScannerHelpFragment()
    }
}